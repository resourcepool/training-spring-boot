import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';

import {AuthGuard} from './service/guards/auth.guard';
import {MaterialModule} from '../material/material.module';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {AuthHeaderInterceptor} from './interceptors/http-interceptor';

const routes = [

];

@NgModule({
  imports: [
    MaterialModule,
    CommonModule,
    RouterModule.forChild(routes),
  ],
  declarations: [
  ],
  exports: [
  ],
  providers: [
    AuthGuard,
    { provide: HTTP_INTERCEPTORS, useClass: AuthHeaderInterceptor, multi: true }
  ]
})
export class AuthModule {}
