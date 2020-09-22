import { Injectable } from '@angular/core';
import { StudijskiProgramInfo, StudijskiProgram } from 'src/app/model/studijski-program/studijski-program';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudijskiProgramService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<StudijskiProgramInfo[]> {
    return this.http.get<StudijskiProgramInfo[]>("http://localhost:8080/api/studijskiProgram");
  }

  getOne(id): Observable<StudijskiProgram> {
    return this.http.get<StudijskiProgram>(`http://localhost:8080/api/studijskiProgram/${id}`);
  }

  addOne(newStudijskiProgram: StudijskiProgramInfo): Observable<StudijskiProgramInfo> {
    return this.http.post<StudijskiProgramInfo>("http://localhost:8080/api/studijskiProgram", newStudijskiProgram);
  }

  updateOne(id, studijskiProgram): Observable<StudijskiProgram> {
    return this.http.put<StudijskiProgram>(`http://localhost:8080/api/studijskiProgram/${id}`, studijskiProgram);
  }

  deleteOne(id): Observable<StudijskiProgram> {
    return this.http.delete<StudijskiProgram>(`http://localhost:8080/api/studijskiProgram/${id}`);
  }
}
