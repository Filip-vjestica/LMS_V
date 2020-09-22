import { Injectable } from '@angular/core';
import { NastavnikNaRealizaciji } from 'src/app/model/nastavnik-na-realizaciji/nastavnik-na-realizaciji';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NastavnikNaRealizacijiService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<NastavnikNaRealizaciji[]> {
    return this.http.get<NastavnikNaRealizaciji[]>("http://localhost:8080/api/nastavnikNaRealizaciji");
  }

  getOne(id): Observable<NastavnikNaRealizaciji> {
    return this.http.get<NastavnikNaRealizaciji>(`http://localhost:8080/api/nastavnikNaRealizaciji/${id}`);
  }

  addOne(newNastavnikNaRealizaciji: NastavnikNaRealizaciji): Observable<NastavnikNaRealizaciji> {
    return this.http.post<NastavnikNaRealizaciji>("http://localhost:8080/api/nastavnikNaRealizaciji", newNastavnikNaRealizaciji);
  }

  updateOne(id, nastavnikNaRealizaciji): Observable<NastavnikNaRealizaciji> {
    return this.http.put<NastavnikNaRealizaciji>(`http://localhost:8080/api/nastavnikNaRealizaciji/${id}`, nastavnikNaRealizaciji);
  }

  deleteOne(id): Observable<NastavnikNaRealizaciji> {
    return this.http.delete<NastavnikNaRealizaciji>(`http://localhost:8080/api/nastavnikNaRealizaciji/${id}`);
  }
}
