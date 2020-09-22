import { Injectable } from '@angular/core';
import { NastavnikInfo, Nastavnik } from 'src/app/model/nastavnik/nastavnik';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Mesto } from 'src/app/model/mesto/mesto';

@Injectable({
  providedIn: 'root'
})
export class NastavnikService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<NastavnikInfo[]> {
    return this.http.get<NastavnikInfo[]>("http://localhost:8080/api/nastavnik");
  }

  getOne(id): Observable<Mesto> {
    return this.http.get<Mesto>(`http://localhost:8080/api/nastavnik/${id}`);
  }

  addOne(newNastavnik: NastavnikInfo): Observable<NastavnikInfo> {
    return this.http.post<NastavnikInfo>("http://localhost:8080/api/nastavnik", newNastavnik);
  }

  updateOne(id, nastavnik): Observable<Nastavnik> {
    return this.http.put<Nastavnik>(`http://localhost:8080/api/nastavnik/${id}`, nastavnik);
  }

  deleteOne(id): Observable<Nastavnik> {
    return this.http.delete<Nastavnik>(`http://localhost:8080/api/nastavnik/${id}`);
  }
}
