import { Injectable } from '@angular/core';
import { RegistrovaniKorisnik } from '../../model/registrovani-korisnik/registrovani-korisnik';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrovaniKorisnikService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<RegistrovaniKorisnik[]> {
    return this.http.get<RegistrovaniKorisnik[]>("http://localhost:8080/api/registrovaniKorisnik");
  }

  getOne(id): Observable<RegistrovaniKorisnik> {
    return this.http.get<RegistrovaniKorisnik>(`http://localhost:8080/api/registrovaniKorisnik/${id}`);
  }

  addOne(newRegistrovaniKorisnik: RegistrovaniKorisnik): Observable<RegistrovaniKorisnik> {
    return this.http.post<RegistrovaniKorisnik>("http://localhost:8080/api/registrovaniKorisnik", newRegistrovaniKorisnik);
  }

  updateOne(id, registrovaniKorisnik): Observable<RegistrovaniKorisnik> {
    return this.http.put<RegistrovaniKorisnik>(`http://localhost:8080/api/registrovaniKorisnik/${id}`, registrovaniKorisnik);
  }

  deleteOne(id): Observable<RegistrovaniKorisnik> {
    return this.http.delete<RegistrovaniKorisnik>(`http://localhost:8080/api/registrovaniKorisnik/${id}`);
  }
}
