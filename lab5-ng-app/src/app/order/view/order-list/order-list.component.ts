import { Component, OnInit } from '@angular/core';
import { Orders } from "../../model/orders";
import { Order } from "../../model/order";
import { OrderService } from "../../service/order.service";

/**
 * Navigable view with list of all orders.
 */
@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  /**
   * @param service orders service
   */
  constructor(private service: OrderService) {
  }

  /**
   * Available orders.
   */
  orders: Orders | undefined;

  ngOnInit(): void {
    this.service.getOrders().subscribe(orders => this.orders = orders);
  }

  /**
   * Deletes selected order.
   *
   * @param order order to be removed
   */
  onDelete(order: Order): void {
    this.service.deleteOrder(order.id).subscribe(() => this.ngOnInit());
  }
}
