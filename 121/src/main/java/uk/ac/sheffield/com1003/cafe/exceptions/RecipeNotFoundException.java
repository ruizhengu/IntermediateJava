package uk.ac.sheffield.com1003.cafe.exceptions;

// created an exception class for RecipeNotFound.
public class RecipeNotFoundException extends Exception {


  //The constructor takes a string parameter "message" which is passed to the parent class constructor using the
  // "super" keyword.
    public RecipeNotFoundException(String message){
        super(message);
    }
    
}
