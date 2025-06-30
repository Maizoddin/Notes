import { Component } from '@angular/core';
import { TestService } from '../services/test.service';

@Component({
  selector: 'app-producer',
  templateUrl: './producer.component.html',
  styleUrls: ['./producer.component.css'],
})
export class ProducerComponent {
  num: number = 1;
  constructor(private testService: TestService) {}
  ngOnInit() {
    setInterval(() => {
      this.testService.custom_subject.next(this.num);
      this.num += 1;
    }, 2000);
  }
}
