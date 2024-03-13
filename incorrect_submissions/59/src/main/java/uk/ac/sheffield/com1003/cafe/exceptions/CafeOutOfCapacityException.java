package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
    public CafeOutOfCapacityException(){
        System.out.println("No space for new orders currently.");
    }
}
