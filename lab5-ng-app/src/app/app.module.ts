import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KnightViewComponent } from './knight/view/knight-view/knight-view.component';
import { KnightListComponent } from './knight/view/knight-list/knight-list.component';
import {NgOptimizedImage} from "@angular/common";
import { OrderListComponent } from './order/view/order-list/order-list.component';
import { OrderViewComponent } from './order/view/order-view/order-view.component';
import {KnightService} from "./knight/service/knight.service";
import {OrderService} from "./order/service/order.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    KnightViewComponent,
    KnightListComponent,
    OrderListComponent,
    OrderViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgOptimizedImage,
    HttpClientModule
  ],
  providers: [
    KnightService,
    OrderService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
