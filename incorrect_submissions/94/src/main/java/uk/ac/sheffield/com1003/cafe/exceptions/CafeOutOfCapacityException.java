package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {

    public CafeOutOfCapacityException(String string) {

    }

    public String toString() {
        return ("Cafe cannot take any more orders and is out of capacity");
    }

}
