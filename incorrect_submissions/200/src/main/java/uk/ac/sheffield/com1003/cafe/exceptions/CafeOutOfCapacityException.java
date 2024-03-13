package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    public CafeOutOfCapacityException(){
        System.out.println("This cafe is at capacity");
    }
}
