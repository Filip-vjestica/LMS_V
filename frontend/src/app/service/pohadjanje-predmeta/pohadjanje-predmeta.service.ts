import { Injectable } from '@angular/core';
import { PohadjanjePredmeta } from 'src/app/model/pohadjanje-predmeta/pohadjanje-predmeta';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PohadjanjePredmetaService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<PohadjanjePredmeta[]> {
    return this.http.get<PohadjanjePredmeta[]>("http://localhost:8080/api/pohadjanjePredmeta");
  }

  getOne(id): Observable<PohadjanjePredmeta> {
    return this.http.get<PohadjanjePredmeta>(`http://localhost:8080/api/pohadjanjePredmeta/${id}`);
  }

  addOne(newPohadjanjePredmeta: PohadjanjePredmeta): Observable<PohadjanjePredmeta> {
    return this.http.post<PohadjanjePredmeta>("http://localhost:8080/api/pohadjanjePredmeta", newPohadjanjePredmeta);
  }

  updateOne(id, pohadjanjePredmeta): Observable<PohadjanjePredmeta> {
    return this.http.put<PohadjanjePredmeta>(`http://localhost:8080/api/pohadjanjePredmeta/${id}`, pohadjanjePredmeta);
  }

  deleteOne(id): Observable<PohadjanjePredmeta> {
    return this.http.delete<PohadjanjePredmeta>(`http://localhost:8080/api/pohadjanjePredmeta/${id}`);
  }
}
