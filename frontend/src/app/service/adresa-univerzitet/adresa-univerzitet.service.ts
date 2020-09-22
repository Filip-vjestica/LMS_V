import { Injectable } from '@angular/core';
import { AdresaUniverzitet } from 'src/app/model/adresa-univerzitet/adresa-univerzitet';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdresaUniverzitetService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<AdresaUniverzitet[]> {
    return this.http.get<AdresaUniverzitet[]>("http://localhost:8080/api/univerzitetAdresa");
  }

  getOne(id): Observable<AdresaUniverzitet> {
    return this.http.get<AdresaUniverzitet>(`http://localhost:8080/api/univerzitetAdresa/${id}`);
  }

  addOne(newAdresaUniverzitet: AdresaUniverzitet): Observable<AdresaUniverzitet> {
    return this.http.post<AdresaUniverzitet>("http://localhost:8080/api/univerzitetAdresa", newAdresaUniverzitet);
  }

  updateOne(id, adresaUniverzitet): Observable<AdresaUniverzitet> {
    return this.http.put<AdresaUniverzitet>(`http://localhost:8080/api/univerzitetAdresa/${id}`, adresaUniverzitet);
  }

  deleteOne(id): Observable<AdresaUniverzitet> {
    return this.http.delete<AdresaUniverzitet>(`http://localhost:8080/api/univerzitetAdresa/${id}`);
  }
}
