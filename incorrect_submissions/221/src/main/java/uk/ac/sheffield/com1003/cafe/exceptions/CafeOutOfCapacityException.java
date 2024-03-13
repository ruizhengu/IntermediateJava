package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    private int orderCapacity;
    public CafeOutOfCapacityException(int orderCapcity) {
        this.orderCapacity = orderCapcity;
    }

    public int getOrderCapacity() {
        return orderCapacity;
    }
}
