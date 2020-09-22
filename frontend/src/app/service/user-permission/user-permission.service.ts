import { Injectable } from '@angular/core';
import { UserPermission } from 'src/app/model/user-permission/user-permission';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserPermissionService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<UserPermission[]> {
    return this.http.get<UserPermission[]>("http://localhost:8080/api/userPermission");
  }

  getOne(id): Observable<UserPermission> {
    return this.http.get<UserPermission>(`http://localhost:8080/api/userPermission/${id}`);
  }

  addOne(newUserPermission: UserPermission): Observable<UserPermission> {
    return this.http.post<UserPermission>("http://localhost:8080/api/userPermission", newUserPermission);
  }

  updateOne(id, userPermission): Observable<UserPermission> {
    return this.http.put<UserPermission>(`http://localhost:8080/api/userPermission/${id}`, userPermission);
  }

  deleteOne(id): Observable<UserPermission> {
    return this.http.delete<UserPermission>(`http://localhost:8080/api/userPermission/${id}`);
  }
}
