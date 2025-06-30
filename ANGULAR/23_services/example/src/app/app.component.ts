import { Component } from '@angular/core';
import { StudentsService } from './services/students.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  constructor(private studentService: StudentsService) {}
  students!: { id: number; name: string }[];
  name!: string;
  ngOnInit() {
    this.students = this.studentService.students;
  }
  addStudent() {
    this.studentService.students.push({
      id: this.students.length,
      name: this.name,
    });
    this.name = '';
  }
}
