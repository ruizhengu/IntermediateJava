package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {

    public String errorMessage;
    public RecipeNotFoundException (String errorMessage)
    {
        this.errorMessage=errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
