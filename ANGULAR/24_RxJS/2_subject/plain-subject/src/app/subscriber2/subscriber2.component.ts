import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { TestService } from '../services/test.service';

@Component({
  selector: 'app-subscriber2',
  templateUrl: './subscriber2.component.html',
  styleUrls: ['./subscriber2.component.css']
})
export class Subscriber2Component {

  sub!: Subscription;

  constructor(private testService: TestService) {}

  onStart() {
    this.sub = this.testService.custom_subject.subscribe((val) => {
      console.log('Subscriber-2 : ', val);
    });
  }

  onStop() {
    this.sub.unsubscribe();
  }
}
