import { Order } from "../../order/model/order";

/**
 * Represents single knight in list.
 */
export interface KnightDetails {
  /**
   * Unique id identifying knight.
   */
  id: string;

  /**
   * Name of the knight.
   */
  name: string;

  /**
   * Knight's age.
   */
  age: number;

  /**
   * Knight's strength.
   */
  strength: number;

  /**
   * Knight's health.
   */
  health: number;

  /**
   * Knight's order.
   */
  order: Order;
}
