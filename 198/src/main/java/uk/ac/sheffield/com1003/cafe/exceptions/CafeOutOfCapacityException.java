package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{

    private String errorMessage;
    public CafeOutOfCapacityException (String errorMessage)
    {
        this.errorMessage=errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

}
