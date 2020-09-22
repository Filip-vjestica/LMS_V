import { Injectable } from '@angular/core';
import { ZvanjeInfo, Zvanje } from 'src/app/model/zvanje/zvanje';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ZvanjeService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<ZvanjeInfo[]> {
    return this.http.get<ZvanjeInfo[]>("http://localhost:8080/api/zvanje");
  }

  getOne(id): Observable<Zvanje> {
    return this.http.get<Zvanje>(`http://localhost:8080/api/zvanje/${id}`);
  }

  addOne(newZvanje: ZvanjeInfo): Observable<ZvanjeInfo> {
    return this.http.post<ZvanjeInfo>("http://localhost:8080/api/zvanje", newZvanje);
  }

  updateOne(id, zvanje): Observable<Zvanje> {
    return this.http.put<Zvanje>(`http://localhost:8080/api/zvanje/${id}`, zvanje);
  }

  deleteOne(id): Observable<Zvanje> {
    return this.http.delete<Zvanje>(`http://localhost:8080/api/zvanje/${id}`);
  }
}
