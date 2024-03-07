package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    public CafeOutOfCapacityException(){
        System.out.println("Error: The Cafe does not have enough capacity to accept any new orders!");
    }
}
