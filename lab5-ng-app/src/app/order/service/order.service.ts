import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Orders } from "../model/orders";
import {Order} from "../model/order";

/**
 * Order management service. Calls REST endpoints.
 */
@Injectable()
export class OrderService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all orders.
   *
   * @return list of orders
   */
  getOrders(): Observable<Orders> {
    return this.http.get<Orders>('/api/orders');
  }

  getOrder(orderId: string): Observable<Order> {
    return this.http.get<Order>('/api/orders/' + orderId);
  }

  /**
   * Removes single order.
   *
   * @param uuid order's id
   */
  deleteOrder(uuid: string): Observable<any> {
    return this.http.delete('/api/orders/' + uuid);
  }

}
