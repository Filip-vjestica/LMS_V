import { Injectable } from '@angular/core';
import { Mesto, MestoInfo } from 'src/app/model/mesto/mesto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MestoService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Mesto[]> {
    return this.http.get<Mesto[]>("http://localhost:8080/api/mesto");
  }

  getOne(id): Observable<Mesto> {
    return this.http.get<Mesto>(`http://localhost:8080/api/mesto/${id}`);
  }

  addOne(newMesto: Mesto): Observable<MestoInfo> {
    return this.http.post<MestoInfo>("http://localhost:8080/api/mesto", newMesto);
  }

  updateOne(id, mesto): Observable<Mesto> {
    return this.http.put<Mesto>(`http://localhost:8080/api/mesto/${id}`, mesto);
  }

  deleteOne(id): Observable<Mesto> {
    return this.http.delete<Mesto>(`http://localhost:8080/api/mesto/${id}`);
  }
}
