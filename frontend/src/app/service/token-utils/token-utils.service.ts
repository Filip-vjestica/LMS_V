import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenUtilsService {

  constructor() { }

  parseToken(token: string){
    try {
      return JSON.parse(atob(token.split(".")[1]));
    } catch{
      alert("Niste ulogovani!");
    }
  }
}