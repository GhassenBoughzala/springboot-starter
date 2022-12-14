import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  employees!: Employee[];
  editEmployee!: Employee;
  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (res: Employee[]) => {
        this.employees = res;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddEmployee(addForm: NgForm): void {
    const on = document.getElementById('add-employee-form');
    on!.click();
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
        console.log(res);
        this.getEmployees();
      },
      (err: HttpErrorResponse) => {
        alert(err.message);
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
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      button.setAttribute('data-target', '#updateEmpModal');
    }
    if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteEmpModal');
    }
    container?.appendChild(button);
    button.click();
  }
}
