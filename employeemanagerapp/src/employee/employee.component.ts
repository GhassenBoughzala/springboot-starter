import { Employee } from './../app/employee';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  @Input() EmployeList!: Employee[]
  @Input() Testing!: Object
  constructor() { }

  ngOnInit(): void {
    console.log('====================================');
    console.log(this.Testing);
    console.log('====================================');
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
