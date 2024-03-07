package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {

//task3
    @Override
    public String getMessage() {
        return super.getMessage() + "Too many Ingriendients" ;
    }

}
