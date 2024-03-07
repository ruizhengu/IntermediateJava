package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    // Variable to store the exceeded capacity
    private int capacity;

    public CafeOutOfCapacityException(int capacity){
        this.capacity = capacity;
    }
}
