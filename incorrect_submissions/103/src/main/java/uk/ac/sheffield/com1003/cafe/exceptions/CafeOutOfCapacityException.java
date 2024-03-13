package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    @Override
    public String getMessage() {
        return "Cafe is out of Capacity";
    }

    @Override
    public String toString() {
        return "Cafe is out of Capacity";
    }
}
