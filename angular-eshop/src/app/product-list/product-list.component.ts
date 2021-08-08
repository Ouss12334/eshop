import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
// http client + rxjs libs
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment"
import { Product } from "../models/product";
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private sanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const category = routeParams.get("category");
    if (category) {
      this.http.get(`${environment.baseUrl}/${environment.productsPath}/${category}`)
        .subscribe(products => {
          console.log(`received products`);
          console.log(products);
          this.products = products as Product[];
        })

    }
  }

  /**
   * sanitize url to show
   */
  sanitizeImageUrl(imageUrl: string): SafeUrl {
    return this.sanitizer.bypassSecurityTrustUrl(imageUrl);
  }

  /**
   * format price for different types of currencies
   */
  formatPrice(unitPrice: number, currency: string): string {
    if (currency == 'TND') {
      if (unitPrice.toString().indexOf(".") != -1) {
        return `${unitPrice.toString().replace(".", ",")}DT`
      }
      return `${unitPrice},000DT`;
    } else if (currency == 'USD')
      if (unitPrice.toString().indexOf(".") != -1) {
        return `$${unitPrice}`;
      }
    return `$${unitPrice}.00`;
    // default
    return `${currency}${unitPrice}.00`
  }

  formatWeight(weight: number): string {
    return weight / 1000 <= 1 ? `${weight}g` : `${weight / 1000}kg`;
  }

}
