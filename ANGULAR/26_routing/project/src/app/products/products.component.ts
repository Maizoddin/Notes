import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../models/product.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  constructor(
    private ps: ProductService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}
  products: Product[] = [];
  ngOnInit() {
    this.ps.getAllProducts().subscribe({
      next: (response) => {
        this.products = response;
      },
      error: (error) => {
        console.log('Error :', error);
      },
    });
  }
  onClick(id: number) {
    this.router.navigate(['product/' + id]);
  }
}
