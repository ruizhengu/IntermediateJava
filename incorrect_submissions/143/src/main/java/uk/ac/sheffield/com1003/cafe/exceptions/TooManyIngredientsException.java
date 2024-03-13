package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {

    private int value;

    public TooManyIngredientsException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }



}
