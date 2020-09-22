import { Injectable } from '@angular/core';
import { StudentNaGodini } from 'src/app/model/student-na-godini/student-na-godini';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentNaGodiniService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<StudentNaGodini[]> {
    return this.http.get<StudentNaGodini[]>("http://localhost:8080/api/studentNaGodini");
  }

  getOne(id): Observable<StudentNaGodini> {
    return this.http.get<StudentNaGodini>(`http://localhost:8080/api/studentNaGodini/${id}`);
  }

  addOne(newStudentNaGodini: StudentNaGodini): Observable<StudentNaGodini> {
    return this.http.post<StudentNaGodini>("http://localhost:8080/api/studentNaGodini", newStudentNaGodini);
  }

  updateOne(id, studentNaGodini): Observable<StudentNaGodini> {
    return this.http.put<StudentNaGodini>(`http://localhost:8080/api/studentNaGodini/${id}`, studentNaGodini);
  }

  deleteOne(id): Observable<StudentNaGodini> {
    return this.http.delete<StudentNaGodini>(`http://localhost:8080/api/studentNaGodini/${id}`);
  }
}
