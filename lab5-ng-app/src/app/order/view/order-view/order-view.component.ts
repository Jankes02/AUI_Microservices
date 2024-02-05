import {Component, OnInit} from '@angular/core';
import {KnightService} from "../../../knight/service/knight.service";
import {ActivatedRoute, Router} from "@angular/router";
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order";
import {Knights} from "../../../knight/model/knights";
import {KnightListComponent} from "../../../knight/view/knight-list/knight-list.component";
import {Knight} from "../../../knight/model/knight";

@Component({
  selector: 'app-order-view',
  templateUrl: './order-view.component.html',
  styleUrls: ['./order-view.component.css']
})
export class OrderViewComponent implements OnInit {
  order: Order | undefined;
  knights: Knights | undefined;

  /**
   *
   * @param service order service
   * @param knightService knight service
   * @param route activated route
   * @param router router
   */
  constructor(private service: OrderService, private knightService: KnightService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getOrder(params['uuid'])
        .subscribe(order => this.order = order);

      this.knightService.getOrderKnights(params['uuid'])
        .subscribe(knights => this.knights = knights)
    });
  }

  onDelete(knight: Knight): void {
    this.knightService.deleteKnight(knight.id).subscribe(() => this.ngOnInit());
  }
}
