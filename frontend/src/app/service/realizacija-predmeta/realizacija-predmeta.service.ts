import { Injectable } from '@angular/core';
import { RealizacijaPredmetaInfo, RealizacijaPredmeta } from 'src/app/model/realizacija-predmeta/realizacija-predmeta';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RealizacijaPredmetaService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<RealizacijaPredmetaInfo[]> {
    return this.http.get<RealizacijaPredmetaInfo[]>("http://localhost:8080/api/realizacijaPredmeta");
  }

  getOne(id): Observable<RealizacijaPredmeta> {
    return this.http.get<RealizacijaPredmeta>(`http://localhost:8080/api/realizacijaPredmeta/${id}`);
  }

  addOne(newRealizacijaPredmeta: RealizacijaPredmetaInfo): Observable<RealizacijaPredmetaInfo> {
    return this.http.post<RealizacijaPredmetaInfo>("http://localhost:8080/api/realizacijaPredmeta", newRealizacijaPredmeta);
  }

  updateOne(id, realizacijaPredmeta): Observable<RealizacijaPredmeta> {
    return this.http.put<RealizacijaPredmeta>(`http://localhost:8080/api/realizacijaPredmeta/${id}`, realizacijaPredmeta);
  }

  deleteOne(id): Observable<RealizacijaPredmeta> {
    return this.http.delete<RealizacijaPredmeta>(`http://localhost:8080/api/realizacijaPredmeta/${id}`);
  }
}
