import { defaultsDeep } from 'lodash';
import firebase from 'firebase';

export enum State {
  Init, Complete
}

export class User {
  uid: string;
  email: string;
  displayName: string;
  photoUrl: string;
  anonymous: boolean
  authenticated: boolean;
  state: State;

  constructor(user?: Partial<User>) {
    defaultsDeep(this, user);
  }

  static from(currentUser: firebase.User): User {
    return new User({uid: currentUser.uid, displayName: currentUser.displayName, email: currentUser.email, photoUrl: currentUser.photoURL});
  }
}
