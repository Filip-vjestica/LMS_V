import { Injectable } from '@angular/core';
import { UniverzitetInfo, Univerzitet } from 'src/app/model/univerzitet/univerzitet';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UniverzitetService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<UniverzitetInfo[]> {
    return this.http.get<UniverzitetInfo[]>("http://localhost:8080/api/univerzitet");
  }

  getOne(id): Observable<Univerzitet> {
    return this.http.get<Univerzitet>(`http://localhost:8080/api/univerzitet/${id}`);
  }

  addOne(newUniverzitet: UniverzitetInfo): Observable<UniverzitetInfo> {
    return this.http.post<UniverzitetInfo>("http://localhost:8080/api/univerzitet", newUniverzitet);
  }

  updateOne(id, univerzitet): Observable<Univerzitet> {
    return this.http.put<Univerzitet>(`http://localhost:8080/api/univerzitet/${id}`, univerzitet);
  }

  deleteOne(id): Observable<Univerzitet> {
    return this.http.delete<Univerzitet>(`http://localhost:8080/api/univerzitet/${id}`);
  }
}
