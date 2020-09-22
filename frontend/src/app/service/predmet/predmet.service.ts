import { Injectable } from '@angular/core';
import { PredmetInfo, Predmet } from 'src/app/model/predmet/predmet';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PredmetService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<PredmetInfo[]> {
    return this.http.get<PredmetInfo[]>("http://localhost:8080/api/predmet");
  }

  getOne(id): Observable<Predmet> {
    return this.http.get<Predmet>(`http://localhost:8080/api/predmet/${id}`);
  }

  addOne(newPredmet: PredmetInfo): Observable<PredmetInfo> {
    return this.http.post<PredmetInfo>("http://localhost:8080/api/predmet", newPredmet);
  }

  updateOne(id, predmet): Observable<Predmet> {
    return this.http.put<Predmet>(`http://localhost:8080/api/predmet/${id}`, predmet);
  }

  deleteOne(id): Observable<Predmet> {
    return this.http.delete<Predmet>(`http://localhost:8080/api/predmet/${id}`);
  }
}
