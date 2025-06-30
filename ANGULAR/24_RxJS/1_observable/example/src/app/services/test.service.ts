import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TestService {
    
  num: number = 1;

  nums_observable: Observable<number> = new Observable((observer) => {
    setInterval(() => {
      observer.next(this.num);
      this.num += 1;
    }, 2000);
  });

}
