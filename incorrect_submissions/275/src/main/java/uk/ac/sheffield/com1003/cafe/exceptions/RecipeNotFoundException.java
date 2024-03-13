/**
* RecipeNotFoundException.java
*
*
* 16/03/2023
*
* @author Mu'az bin Mohamad Nor Sazelim
*/

package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
