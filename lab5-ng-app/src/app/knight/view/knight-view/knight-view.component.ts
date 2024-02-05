import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {KnightService} from "../../service/knight.service";
import {KnightDetails} from "../../model/knight-details";

@Component({
  selector: 'app-knight-view',
  templateUrl: './knight-view.component.html',
  styleUrls: ['./knight-view.component.css']
})
export class KnightViewComponent implements OnInit {
  knight: KnightDetails | undefined;

  /**
   *
   * @param service character service
   * @param route activated route
   * @param router router
   */
  constructor(private service: KnightService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getKnight(params['uuid'])
        .subscribe(knight => this.knight = knight)
    });
  }
}
