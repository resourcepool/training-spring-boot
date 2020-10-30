import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ListBooksComponent} from './pages/list-books/list-books.component';
import {ListBooksAdminComponent} from './pages/list-books-admin/list-books-admin.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AngularFireModule} from '@angular/fire';
import {AngularFireAuthModule} from '@angular/fire/auth';
import {environment} from '../environments/environment';
import {AngularFirestoreModule} from '@angular/fire/firestore';
import {SignInComponent} from './pages/sign-in/sign-in.component';
import {AuthModule} from './auth/auth.module';
import {MaterialModule} from './material/material.module';

@NgModule({
    declarations: [
        AppComponent,
        ListBooksComponent,
        ListBooksAdminComponent,
        SignInComponent
    ],
    imports: [
        AuthModule,
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        AngularFireModule.initializeApp(environment.firebase),
        AngularFireAuthModule,
        MaterialModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
