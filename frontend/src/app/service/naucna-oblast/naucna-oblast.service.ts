import { Injectable } from '@angular/core';
import { NaucnaOblastInfo, NaucnaOblast } from 'src/app/model/naucna-oblast/naucna-oblast';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NaucnaOblastService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<NaucnaOblastInfo[]> {
    return this.http.get<NaucnaOblastInfo[]>("http://localhost:8080/api/naucnaOblast");
  }

  getOne(id): Observable<NaucnaOblast> {
    return this.http.get<NaucnaOblast>(`http://localhost:8080/api/naucnaOblast/${id}`);
  }

  addOne(newNaucnaOblast: NaucnaOblastInfo): Observable<NaucnaOblastInfo> {
    return this.http.post<NaucnaOblastInfo>("http://localhost:8080/api/naucnaOblast", newNaucnaOblast);
  }

  updateOne(id, naucnaOblast): Observable<NaucnaOblast> {
    return this.http.put<NaucnaOblast>(`http://localhost:8080/api/naucnaOblast/${id}`, naucnaOblast);
  }

  deleteOne(id): Observable<NaucnaOblast> {
    return this.http.delete<NaucnaOblast>(`http://localhost:8080/api/naucnaOblast/${id}`);
  }
}
