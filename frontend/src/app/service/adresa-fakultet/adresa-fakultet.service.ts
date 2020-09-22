import { Injectable } from '@angular/core';
import { AdresaFakultet } from 'src/app/model/adresa-fakultet/adresa-fakultet';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdresaFakultetService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<AdresaFakultet[]> {
    return this.http.get<AdresaFakultet[]>("http://localhost:8080/api/fakultetAdresa");
  }

  getOne(id): Observable<AdresaFakultet> {
    return this.http.get<AdresaFakultet>(`http://localhost:8080/api/fakultetAdresa/${id}`);
  }

  addOne(newAdresaFakultet: AdresaFakultet): Observable<AdresaFakultet> {
    return this.http.post<AdresaFakultet>("http://localhost:8080/api/fakultetAdresa", newAdresaFakultet);
  }

  updateOne(id, adresaFakultet): Observable<AdresaFakultet> {
    return this.http.put<AdresaFakultet>(`http://localhost:8080/api/fakultetAdresa/${id}`, adresaFakultet);
  }

  deleteOne(id): Observable<AdresaFakultet> {
    return this.http.delete<AdresaFakultet>(`http://localhost:8080/api/fakultetAdresa/${id}`);
  }
}
