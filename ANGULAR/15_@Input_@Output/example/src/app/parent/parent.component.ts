import { Component } from '@angular/core';

@Component({
  selector: 'parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css'],
})
export class ParentComponent {
  users: string[] = ['John', 'Alex', 'Michel', 'Steve', 'Alex', 'Chris', 'Roy'];
  handleRemove(name: string) {
    this.users.splice(this.users.indexOf(name), 1);
  }
}
