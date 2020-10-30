import {Router} from '@angular/router';
import {Injectable, OnDestroy} from '@angular/core';

import {AngularFireAuth} from '@angular/fire/auth';
import firebase from 'firebase/app';
import 'firebase/auth';
import 'firebase/database';

import {State, User} from '../../models/user.model';
import {from, Observable, of, ReplaySubject, Subject} from 'rxjs';
import {startWith, switchMap, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AuthService implements OnDestroy {

  private latestAuthState: firebase.User = null;
  private authenticating: boolean;
  private readonly idTokenSubject: Subject<string>;
  private readonly currentUserSubject: Subject<User>;

  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }

  _getNotAuthenticatedDummyUser(state: State) {
    const user = new User();
    user.anonymous = true;
    user.authenticated = false;
    user.state = state;
    return user;
  }

  constructor(private afAuth: AngularFireAuth,
              private _router: Router) {
    this.currentUserSubject = new ReplaySubject<User>(1);
    this.idTokenSubject = new ReplaySubject<string>(1);

    // Everytime firebase has a new auth state, it will trigger this action here.
    // Does it handle disconnects? Maybe let's see later
    this.afAuth.authState
      .pipe(switchMap((authState) => {
        return this._authFunnel(authState);
      }))
      .pipe(startWith((JSON.parse(localStorage.getItem('takima-school:user')) || {
        user: this._getNotAuthenticatedDummyUser(State.Complete),
        idToken: null
      })))
      .subscribe((result) => {
        this._publishAuth(result);
      });

  }

  private _authFunnel(authState: firebase.User): Observable<{user: User, idToken: string}> {
    console.log('Received user', authState);
    this.latestAuthState = authState;
    if (!authState) {
      // We have checked and there are no logged in users for now. Set to anonymous
      const user = {user: this._getNotAuthenticatedDummyUser(State.Complete), idToken: null};
      this.authenticating = false;
      return of(user);
    }
    console.log('User from authState is not null. Refreshing data from server');
    // There is one logged in user. Fetch his metadata and his idtoken
    return this.refresh(authState, false);
  }

  currentUserObservable(): Observable<User> {
    return this.currentUserSubject;
  }

  currentIdToken(): Observable<string> {
    return this.idTokenSubject;
  }

  refreshFromAuthState() {
    return this.refresh(this.latestAuthState);
  }

  refresh(authState: firebase.User, publishAfterRefresh: boolean = true): Observable<any> {
    return from(this.refreshUserDetails(authState))
      .pipe(tap((result) => {
        localStorage.setItem('takima-school:user', JSON.stringify(result));
        this.authenticating = false;
        if (publishAfterRefresh) {
          this._publishAuth(result);
        }
      }));
  }

  _publishAuth(result: { user: User, idToken: string }) {
    if (result) {
      console.log('Auth Published');
      console.log(result);
      this.idTokenSubject.next(result.idToken);
      this.currentUserSubject.next(result.user);
    } else {
      console.log('Null Auth Published');
      this.idTokenSubject.next(null);
      this.currentUserSubject.next(null);
    }
  }

  async refreshUserDetails(authState: firebase.User): Promise<{ user: User, idToken: string }> {
    const user = User.from(authState);
    const idToken = await authState.getIdTokenResult(true);
    this.idTokenSubject.next(idToken.token);
    user.authenticated = true;
    user.state = State.Complete;
    return {user, idToken: idToken.token};
  }

  googleSignIn(): Promise<void> {
    if (!this.authenticating) {
      this.authenticating = true;
      const provider = new firebase.auth.GoogleAuthProvider();
      return this._socialSignIn(provider);
    } else {
      return Promise.resolve()
    }
  }

  signOut(): Promise<any> {
    localStorage.removeItem('takima-school:user');
    return this.afAuth.signOut()
      .then(() => {
        this.idTokenSubject.next(null);
        this.currentUserSubject.next(this._getNotAuthenticatedDummyUser(State.Init));
      });
  }

  private _socialSignIn(provider): Promise<void> {
    return this.afAuth.signInWithPopup(provider).then();
  }
}
