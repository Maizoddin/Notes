import { Injectable } from '@angular/core';
import { BehaviorSubject, ReplaySubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TestService {
 // Plain Subject
  custom_subject: Subject<number> = new Subject();

// Behavioral Subject
//  custom_subject: BehaviorSubject<number> = new BehaviorSubject(1);

 //   Replay Subject
 //   custom_subject:ReplaySubject<number> = new ReplaySubject;

}
