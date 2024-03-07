package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    private String message;

    public CafeOutOfCapacityException(String message) { this.message = message;}

    public String getMessage() { return message; }
}
