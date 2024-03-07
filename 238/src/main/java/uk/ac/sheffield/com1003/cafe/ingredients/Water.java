/**
 * Water.java
 * The water class represents a type of ingredient in a cafe.
 * It extends the Ingredient class and contains constructors to set the amount of water.
 * Overrides the toString() method, providing a string representation of the Water object.
 * @version 1.0 10/03/2023
 * @author Unknown
 */


package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }

    /**
     * Constructor for Water class which takes an amount parameter and sets the amount of water accordingly.
     * @param amount the amount of water to set
     */
    public Water(int amount) {
        this.amount = amount;
    }

    /**
     * Returns string representation of Water object stating its unit and amount properties.
     * @return a string representation of the Water object
     */
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
