/**
 * RecipeNotFoundException.java
 *
 * @version 1.0 15/03/2023
 * @author Naseem Hoque
 */

package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{
    private String value;

    public RecipeNotFoundException(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
