/**
* Syrup.java
*
* @version 14/03/2023
*
* @author Artem Vakhutinskiy
*/

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 5;
        this.flavour = "Chocolate";
    }

    /**
     * Constructor that takes the amount of coffee as parameters.
     * @param flavour
     */
    public Syrup(String flavour) {
        this.unit = Unit.ML;
        this.amount = 5;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
