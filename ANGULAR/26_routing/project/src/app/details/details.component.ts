import { Component, Input } from '@angular/core';
import { Product } from '../models/product.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent {
  id: number;
  product: Product;
  constructor(
    private activatedRoute: ActivatedRoute,
    private ps: ProductService,
    private router: Router
  ) {}
  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params) => {
      this.id = +params.get('id');
      this.ps.getAProduct(this.id).subscribe({
        next: (response) => (this.product = response),
        error: (err) => console.log('Error', err),
      });
    });
  }
  onPrev() {
    if (this.id == 1) {
      this.id = 10;
    }
    this.router.navigate(['product', this.id - 1]);
  }
  onNext() {
    if (this.id == 9) {
      this.id = 0;
    }
    this.router.navigate(['product', this.id + 1]);
  }
}
