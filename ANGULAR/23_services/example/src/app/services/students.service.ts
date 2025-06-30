import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class StudentsService {
  constructor() {}
  students: { id: number; name: string }[] = [
    { id: 1, name: 'John' },
    { id: 2, name: 'Alex' },
    { id: 3, name: 'Andrew' },
    { id: 4, name: 'Shane' },
  ];
}
