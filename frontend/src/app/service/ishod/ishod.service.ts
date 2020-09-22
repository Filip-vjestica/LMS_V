import { Injectable } from '@angular/core';
import { IshodInfo, Ishod } from 'src/app/model/ishod/ishod';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IshodService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<IshodInfo[]> {
    return this.http.get<IshodInfo[]>("http://localhost:8080/api/ishod");
  }

  getOne(id): Observable<Ishod> {
    return this.http.get<Ishod>(`http://localhost:8080/api/ishod/${id}`);
  }

  addOne(newIshod: IshodInfo): Observable<IshodInfo> {
    return this.http.post<IshodInfo>("http://localhost:8080/api/ishod", newIshod);
  }

  updateOne(id, ishod): Observable<Ishod> {
    return this.http.put<Ishod>(`http://localhost:8080/api/ishod/${id}`, ishod);
  }

  deleteOne(id): Observable<Ishod> {
    return this.http.delete<Ishod>(`http://localhost:8080/api/ishod/${id}`);
  }
}
