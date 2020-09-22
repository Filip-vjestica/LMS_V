import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable, onErrorResumeNext } from 'rxjs';
import { LoginService } from '../app/service/login/login.service';

const TOKEN_HEADER_KEY = 'Authorization';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  private token: string = null;


  constructor(private login: LoginService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.token = this.login.getToken();
    if (this.token) {
      req = req.clone({
        headers: req.headers.set(TOKEN_HEADER_KEY, this.token)
      });
    }

    return next.handle(req);
  }
}
