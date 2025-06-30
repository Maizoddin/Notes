import { Component } from '@angular/core';
import { Student } from './models/student.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  searchText: string = '';

  students: Student[] = [
    { name: 'John', gender: 'Male' },
    { name: 'Alexa', gender: 'Female' },
    { name: 'Roy', gender: 'Male' },
    { name: 'Perry', gender: 'Female' },
  ];

  onAdd() {
    this.students.push({ name: 'Jimmy', gender: 'Female' });
  }
}
