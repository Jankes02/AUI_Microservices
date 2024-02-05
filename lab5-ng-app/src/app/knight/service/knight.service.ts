import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Knights} from "../model/knights";
import {KnightDetails} from "../model/knight-details";

@Injectable()
export class KnightService {
  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {}

  /**
   * Fetches all knights.
   *
   * @return list of knights
   */
  getKnights(): Observable<Knights> {
    return this.http.get<Knights>('/api/knights');
  }

  /**
   * Fetches single knights.
   *
   * @param uuid knight's id
   * @return single knights
   */
  getKnight(uuid: string): Observable<KnightDetails> {
    return this.http.get<KnightDetails>('/api/knights/' + uuid);
  }

  /**
   * Removes single knight.
   *
   * @param uuid knight's id
   */
  deleteKnight(uuid: string): Observable<any> {
    return this.http.delete('/api/knights/' + uuid);
  }

  getOrderKnights(uuid: string): Observable<Knights> {
    return this.http.get<Knights>('/api/orders/' + uuid + '/knights')
  }
}
