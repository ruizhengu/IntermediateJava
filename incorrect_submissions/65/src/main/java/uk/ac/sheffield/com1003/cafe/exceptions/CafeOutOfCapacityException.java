package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Order;

/**
 * An exception that gets thrown when attempting to add another order to the Cafe class's order list when it is already
 * full.
 * Stores the excess order object for use in exception handling.
 */
public class CafeOutOfCapacityException extends Exception {

    private final Order excessOrder;

    public CafeOutOfCapacityException(Order excessOrder) {
        this.excessOrder = excessOrder;
    }

    public Order getExcessOrder() {
        return excessOrder;
    }
}
