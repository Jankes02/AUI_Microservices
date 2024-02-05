import { Component } from '@angular/core';
import {Knights} from "../../model/knights";
import {KnightService} from "../../service/knight.service";
import {Knight} from "../../model/knight";

@Component({
  selector: 'app-knight-list',
  templateUrl: './knight-list.component.html',
  styleUrls: ['./knight-list.component.css']
})
export class KnightListComponent {
  /**
   * @param service knights service
   */
  constructor(private service: KnightService) {
  }

  /**
   * Available knights.
   */
  knights: Knights | undefined;

  ngOnInit(): void {
    this.service.getKnights().subscribe(knights => this.knights = knights);
  }

  /**
   * Deletes selected knight.
   *
   * @param knight knight to be removed
   */
  onDelete(knight: Knight): void {
    this.service.deleteKnight(knight.id).subscribe(() => this.ngOnInit());
  }
}
