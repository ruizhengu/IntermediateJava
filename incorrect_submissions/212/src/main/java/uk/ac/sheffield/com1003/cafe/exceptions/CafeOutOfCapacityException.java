package uk.ac.sheffield.com1003.cafe.exceptions;


public class CafeOutOfCapacityException extends Exception {
    
    /**
     * print a message to user that tells the order placed [by calling placeOrder()] is not executed and by removing placeOrder() calls may fix the error. 
     * @param orderLength return size of the order can be placed for the cafe.
     */
    public CafeOutOfCapacityException(int orderLength) {
        System.out.println("Cafe out of capacity to receive order more than " + orderLength + ". Please remove a few placeOrder() calls.");
    }
}
