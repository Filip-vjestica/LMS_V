import { Injectable } from '@angular/core';
import { Drzava, DrzavaInfo } from 'src/app/model/drzava/drzava';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DrzavaService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Drzava[]> {
    return this.http.get<Drzava[]>("http://localhost:8080/api/drzava");
  }

  getOne(id): Observable<Drzava> {
    return this.http.get<Drzava>(`http://localhost:8080/api/drzava/${id}`);
  }

  addOne(newDrzava: DrzavaInfo): Observable<DrzavaInfo> {
    return this.http.post<DrzavaInfo>("http://localhost:8080/api/drzava", newDrzava);
  }

  updateOne(id, drzava): Observable<Drzava> {
    return this.http.put<Drzava>(`http://localhost:8080/api/drzava/${id}`, drzava);
  }

  deleteOne(id): Observable<Drzava> {
    return this.http.delete<Drzava>(`http://localhost:8080/api/drzava/${id}`);
  }
}
