import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegistrovaniKorisnik, RegistrovaniKorisnikInfo } from '../../model/registrovani-korisnik/registrovani-korisnik';
import {TokenUtilsService } from '../../service/token-utils/token-utils.service';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient,private tokenUtils: TokenUtilsService ) {}

  private user: RegistrovaniKorisnik;
  private token = null;

  login(user) {
    return this.http.post('http://localhost:8080/api/login', user).pipe((r) => {
      r.subscribe((t) => {
        this.token = t['token'];
        this.user = JSON.parse(atob(t['token'].split('.')[1]));
      });
      return r;
    });
  }


  validateRoles(roles) {
    if (this.user.roles == roles){
      return true;
    }
    return false;
      
  }

  getToken() {
    if (!this.user) {
      return '';
    }
    return this.token;
  }
}
