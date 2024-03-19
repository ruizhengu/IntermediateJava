package uk.ac.sheffield.com1003.cafe.solution.exceptions;
/**
 * Task 3 - Checked exception thrown when an attempt to place and order occurs when the this is no
 * more spare capacity to throw orders (when index = Cafe@orders.length)
 *
 * @version 1.3 16/03/2023
 * @since 0.3
 * @author unknown
 */
public class CafeOutOfCapacityException extends Exception {

    /**
     * Constructor that sets the message to display details of the order state in the Cafe instance
     * where this exception was thrown from.
     * @param nextToServeIndex indexNextOrderToServe value in the Cafe instance
     * @param nextOrderIndex indexNextOrderToOrder value in the Cafe instance
     * @param capacity length of the orders array in the Cafe instance
     */
    public CafeOutOfCapacityException(int nextToServeIndex, int nextOrderIndex, int capacity) {
        super("Next to serve index: " + nextToServeIndex
            + " Next to order index: " + nextOrderIndex
            + " Order capacity: " + capacity);
    }
}
