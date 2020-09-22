import { Injectable } from '@angular/core';
import { FakultetInfo, Fakultet } from 'src/app/model/fakultet/fakultet';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FakultetService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<FakultetInfo[]> {
    return this.http.get<FakultetInfo[]>("http://localhost:8080/api/fakultet");
  }

  getOne(id): Observable<Fakultet> {
    return this.http.get<Fakultet>(`http://localhost:8080/api/fakultet/${id}`);
  }

  addOne(newFakultet: FakultetInfo): Observable<FakultetInfo> {
    return this.http.post<FakultetInfo>("http://localhost:8080/api/fakultet", newFakultet);
  }

  updateOne(id, fakultet): Observable<Fakultet> {
    return this.http.put<Fakultet>(`http://localhost:8080/api/fakultet/${id}`, fakultet);
  }

  deleteOne(id): Observable<Fakultet> {
    return this.http.delete<Fakultet>(`http://localhost:8080/api/fakultet/${id}`);
  }
}
