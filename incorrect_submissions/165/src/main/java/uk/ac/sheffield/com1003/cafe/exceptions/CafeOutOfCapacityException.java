package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    private boolean outOfCapacity;

    public CafeOutOfCapacityException(){
        this.outOfCapacity = true;
    }
}
