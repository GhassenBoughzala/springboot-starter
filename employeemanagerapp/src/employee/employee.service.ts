import { Employee } from '../app/employee';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiServerURL = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getEmployees(): Observable<Employee[]>{
      return this.http.get<Employee[]>(`${this.apiServerURL}/employee`)
  }

  public addEmployee(employee: Employee): Observable<Employee>{
      return this.http.post<Employee>(`${this.apiServerURL}/employee`, employee)
  }

  public updateEmployee(employee: Employee): Observable<Employee>{
      return this.http.put<Employee>(`${this.apiServerURL}/employee`, employee)
  }

  public deleteEmployee(employeeId: String): Observable<void>{
      return this.http.delete<void>(`${this.apiServerURL}/employee/${employeeId}`)
  }
}
