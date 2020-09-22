import { Component, OnInit } from '@angular/core';
import {RegistrovaniKorisnik, RegistrovaniKorisnikInfo} from '../model/registrovani-korisnik/registrovani-korisnik';
import {RegistrovaniKorisnikService} from '../service/registrovani-korisnik/registrovani-korisnik.service';

@Component({
  selector: 'app-korisnici',
  templateUrl: './korisnici.component.html',
  styleUrls: ['./korisnici.component.css']
})
export class KorisniciComponent implements OnInit {
  users: RegistrovaniKorisnikInfo[] = [];
  constructor(private userService: RegistrovaniKorisnikService) { 
  }

  ngOnInit(): void {
    this.userService.getAll().subscribe((r) => (this.users = r));
  }

}
