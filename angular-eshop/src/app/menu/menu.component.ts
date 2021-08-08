import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  redirect(category: string) {
    // fix for route not changing on same url with different path variable
    this.router.navigateByUrl("/", {skipLocationChange: true})
      .then(() =>
        this.router.navigate(['/products', category] /*{ relativeTo: this.route }*/))
  }

}
