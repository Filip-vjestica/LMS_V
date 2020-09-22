import { Injectable } from '@angular/core';
import { PermissionInfo, Permission } from 'src/app/model/permission/permission';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PermissionService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<PermissionInfo[]> {
    return this.http.get<PermissionInfo[]>("http://localhost:8080/api/permission");
  }

  getOne(id): Observable<Permission> {
    return this.http.get<Permission>(`http://localhost:8080/api/permission/${id}`);
  }

  addOne(newPermission: PermissionInfo): Observable<PermissionInfo> {
    return this.http.post<PermissionInfo>("http://localhost:8080/api/permission", newPermission);
  }

  updateOne(id, permission): Observable<Permission> {
    return this.http.put<Permission>(`http://localhost:8080/api/permission/${id}`, permission);
  }

  deleteOne(id): Observable<Permission> {
    return this.http.delete<Permission>(`http://localhost:8080/api/permission/${id}`);
  }
}
