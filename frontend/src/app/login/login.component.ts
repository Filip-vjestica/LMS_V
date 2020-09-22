import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login/login.service';
import { RegistrovaniKorisnikInfo1,RegistrovaniKorisnik } from '../model/registrovani-korisnik/registrovani-korisnik';
import { Router } from '@angular/router';
import {RegistrovaniKorisnikService} from '../service/registrovani-korisnik/registrovani-korisnik.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: RegistrovaniKorisnik[] = [];
  idP:null;

  user: RegistrovaniKorisnikInfo1 = {
    id: null,
    username: null,
    password: null,
    roles: null,
  };

  constructor(private loginService: LoginService ,private router: Router,private us: RegistrovaniKorisnikService) { }

  ngOnInit(): void {
    this.us.getAll().subscribe(r => this.users = r);
  }

  login() {
    for(let a of this.users){
      if(a.username == this.user.username){
        a.id = this.idP;

      }
    }
    this.loginService.login(this.user).subscribe(
      (r) => this.router.navigate(["/univerzitet"]),
      (err) => {
        alert("Neuspesan Login!");
      }
    );
  }

}
