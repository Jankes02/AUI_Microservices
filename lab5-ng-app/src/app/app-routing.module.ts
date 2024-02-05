import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {KnightListComponent} from "./knight/view/knight-list/knight-list.component";
import {OrderListComponent} from "./order/view/order-list/order-list.component";
import {KnightViewComponent} from "./knight/view/knight-view/knight-view.component";
import {OrderViewComponent} from "./order/view/order-view/order-view.component";

const routes: Routes = [
  {
    component: KnightListComponent,
    path: "knights"
  },
  {
    component: OrderListComponent,
    path: "orders"
  },
  {
    component: KnightViewComponent,
    path: "knights/:uuid"
  },
  {
    component: OrderViewComponent,
    path: "orders/:uuid"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
