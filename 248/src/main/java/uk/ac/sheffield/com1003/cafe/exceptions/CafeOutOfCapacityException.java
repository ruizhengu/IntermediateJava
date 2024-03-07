package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Order;

public class CafeOutOfCapacityException extends Exception {
  Order order;
  /**
   * Exception to be thrown when order is being added to Cafe.orders, but
   * the order array is full.
   */
  public CafeOutOfCapacityException(Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return order;
  }
}
