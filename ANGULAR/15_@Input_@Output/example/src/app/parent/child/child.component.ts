import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css'],
})
export class ChildComponent {
  @Input() name: string = '';
  @Output() customEvent = new EventEmitter<string>();
  onClick() {
    this.customEvent.emit(this.name);
  }
}
