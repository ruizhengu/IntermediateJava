package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    public String errorMessage;
    public TooManyIngredientsException (String errorMessage)
    {
        this.errorMessage=errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
