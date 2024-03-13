/**
 * Thrown whenever the maximum number of orders has been reached and the customer wants to place a new order
 */

package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {

    private String value;

    public CafeOutOfCapacityException(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
