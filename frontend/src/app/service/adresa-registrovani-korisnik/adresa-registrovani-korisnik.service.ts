import { Injectable } from '@angular/core';
import { AdresaRegistrovaniKorisnik } from 'src/app/model/adresa-registrovani-korisnik/adresa-registrovani-korisnik';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdresaRegistrovaniKorisnikService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<AdresaRegistrovaniKorisnik[]> {
    return this.http.get<AdresaRegistrovaniKorisnik[]>("http://localhost:8080/api/registrovaniKorisnikAdresa");
  }

  getOne(id): Observable<AdresaRegistrovaniKorisnik> {
    return this.http.get<AdresaRegistrovaniKorisnik>(`http://localhost:8080/api/registrovaniKorisnikAdresa/${id}`);
  }

  addOne(newAdresaRegistrovaniKorisnik: AdresaRegistrovaniKorisnik): Observable<AdresaRegistrovaniKorisnik> {
    return this.http.post<AdresaRegistrovaniKorisnik>("http://localhost:8080/api/registrovaniKorisnikAdresa", newAdresaRegistrovaniKorisnik);
  }

  updateOne(id, adresaRegistrovaniKorisnik): Observable<AdresaRegistrovaniKorisnik> {
    return this.http.put<AdresaRegistrovaniKorisnik>(`http://localhost:8080/api/registrovaniKorisnikAdresa/${id}`, adresaRegistrovaniKorisnik);
  }

  deleteOne(id): Observable<AdresaRegistrovaniKorisnik> {
    return this.http.delete<AdresaRegistrovaniKorisnik>(`http://localhost:8080/api/registrovaniKorisnikAdresa/${id}`);
  }
}
