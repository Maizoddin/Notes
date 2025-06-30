import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  private url: string = 'http://localhost:3000/courses';

  getAllProducts(): Observable<Product[]> {
    return this.http
      .get<Product[]>(this.url)
      .pipe(catchError(this.handleError));
  }

  getAProduct(id: number):Observable<Product> {
    return this.http
      .get<Product>(this.url + '/' + id)
      .pipe(catchError(this.handleError));
  }

  handleError(err) {
    if (err.error instanceof ErrorEvent) {
      console.log('Client side error!!');
    } else {
      console.log('Server side error!!');
    }
    return throwError(() => 'Something went wrong');
  }
}
