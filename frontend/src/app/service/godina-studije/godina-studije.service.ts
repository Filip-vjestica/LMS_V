import { Injectable } from '@angular/core';
import { GodinaStudijeInfo, GodinaStudije } from 'src/app/model/godina-studije/godina-studije';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GodinaStudijeService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<GodinaStudijeInfo[]> {
    return this.http.get<GodinaStudijeInfo[]>("http://localhost:8080/api/godinaStudija");
  }

  getOne(id): Observable<GodinaStudije> {
    return this.http.get<GodinaStudije>(`http://localhost:8080/api/godinaStudija/${id}`);
  }

  addOne(newGodinaStudije: GodinaStudijeInfo): Observable<GodinaStudijeInfo> {
    return this.http.post<GodinaStudijeInfo>("http://localhost:8080/api/godinaStudija", newGodinaStudije);
  }

  updateOne(id, godinaStudije): Observable<GodinaStudije> {
    return this.http.put<GodinaStudije>(`http://localhost:8080/api/godinaStudija/${id}`, godinaStudije);
  }

  deleteOne(id): Observable<GodinaStudije> {
    return this.http.delete<GodinaStudije>(`http://localhost:8080/api/godinaStudija/${id}`);
  }
}
