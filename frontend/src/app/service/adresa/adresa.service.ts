import { Injectable } from '@angular/core';
import { Adresa } from 'src/app/model/adresa/adresa';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdresaService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<Adresa[]> {
    return this.http.get<Adresa[]>("http://localhost:8080/api/adresa");
  }

  getOne(id): Observable<Adresa> {
    return this.http.get<Adresa>(`http://localhost:8080/api/adresa/${id}`);
  }

  addOne(newAdresa: Adresa): Observable<Adresa> {
    return this.http.post<Adresa>("http://localhost:8080/api/adresa", newAdresa);
  }

  updateOne(id, adresa): Observable<Adresa> {
    return this.http.put<Adresa>(`http://localhost:8080/api/adresa/${id}`, adresa);
  }

  deleteOne(id): Observable<Adresa> {
    return this.http.delete<Adresa>(`http://localhost:8080/api/adresa/${id}`);
  }
}
