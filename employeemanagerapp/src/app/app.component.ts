import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  employees!: Employee[];
  editEmployee!: Employee;
  deleteEmployee!: Employee;
  EMP!: Employee[]
  test= {test: 'test'}
  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (res: Employee[]) => {
        this.EMP = res;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddEmployee(addForm: NgForm): void {
    document.getElementById('add-employee-form')?.click();    
    this.employeeService.addEmployee(addForm.value).subscribe(
      (res: Employee) => {
        console.log(res);
        this.getEmployees();
        addForm.reset();
      },
      (err: HttpErrorResponse) => {
        alert(err.message);
        addForm.reset();
      }
    );
  }

  public onUpdateEmployee(employee: Employee): void {
    this.employeeService.updateEmployee(employee).subscribe(
      (res: Employee) => {
        this.getEmployees();
      },
      (err: HttpErrorResponse) => {
        alert(err.message);
      }
    );
  }

  public onDeleteEmloyee(employeeId: String): void {
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onOpenModal(employee: Employee | null, mode: String): void {
    const container = document.getElementById('main');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmpModal');
    }
    if (mode === 'edit') {
      button.setAttribute('data-target', '#editEmpModal');
    }
    if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteEmpModal');
    }
    container?.appendChild(button);
    button.click();
  }
}
