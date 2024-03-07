package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Cafe;

public class CafeOutOfCapacityException extends Exception{
    
    public CafeOutOfCapacityException() {
        System.out.println("Cafe's capacity is currently full. Please come back later!");
    }
    
}
