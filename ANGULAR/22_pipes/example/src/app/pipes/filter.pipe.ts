import { Pipe, PipeTransform } from '@angular/core';
import { Student } from '../models/student.model';

@Pipe({
  name: 'filter',
  pure: false,
})
export class FilterPipe implements PipeTransform {
  transform(students: Student[], key: string): Student[] {
    if (key == '') return students;
    return students.filter(
      (student: Student) =>
        student.gender.toLowerCase() === key.toLocaleLowerCase()
    );
  }
}
