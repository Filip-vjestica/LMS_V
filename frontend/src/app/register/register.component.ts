import { Component, OnInit } from '@angular/core';
import { RegistrovaniKorisnik } from '../model/registrovani-korisnik/registrovani-korisnik';
import { RegistrovaniKorisnikService } from '../service/registrovani-korisnik/registrovani-korisnik.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  users: RegistrovaniKorisnik[] = [];
  
  user: RegistrovaniKorisnik = {
    id: 0,
    username: null,
    password:null,
    ime:null,
    prezime:null,
    jmbg:null,
    email:null,
    studentNaGodinama:null,
    pohadjanjePredmeta:null,
    registrovaniKorisnikAdrese:null,
    roles: "REGISTROVANI-KORISNIK"
  };

  constructor(private us: RegistrovaniKorisnikService,private router: Router ) {}

  ngOnInit(): void {
    this.us.getAll().subscribe(r => this.users = r);
  }

  register() {
    for(let a  of this.users){
      if(a.username == this.user.username){
        alert("Username je zauzet!");
        return
      }
    } 
    this.us.addOne(this.user).subscribe((r) => this.router.navigate(["/login"]));
  }
}
