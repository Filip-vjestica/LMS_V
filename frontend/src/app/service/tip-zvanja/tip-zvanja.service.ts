import { Injectable } from '@angular/core';
import { TipZvanjaInfo, TipZvanja } from 'src/app/model/tip-zvanja/tip-zvanja';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipZvanjaService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<TipZvanjaInfo[]> {
    return this.http.get<TipZvanjaInfo[]>("http://localhost:8080/api/tipZvanja");
  }

  getOne(id): Observable<TipZvanja> {
    return this.http.get<TipZvanja>(`http://localhost:8080/api/tipZvanja/${id}`);
  }

  addOne(newTipZvanja: TipZvanjaInfo): Observable<TipZvanjaInfo> {
    return this.http.post<TipZvanjaInfo>("http://localhost:8080/api/tipZvanja", newTipZvanja);
  }

  updateOne(id, tipZvanja): Observable<TipZvanja> {
    return this.http.put<TipZvanja>(`http://localhost:8080/api/tipZvanja/${id}`, tipZvanja);
  }

  deleteOne(id): Observable<TipZvanja> {
    return this.http.delete<TipZvanja>(`http://localhost:8080/api/tipZvanja/${id}`);
  }
}
