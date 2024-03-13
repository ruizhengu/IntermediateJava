package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {

    //task3
        @Override
        public String getMessage() {
            return super.getMessage() + "Recipe not found" ;
        }

}
