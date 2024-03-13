package uk.ac.sheffield.com1003.cafe.ingredients;

/**
The Ingredient class extends the Coffee class (subclass) and represents coffee as an ingredient.
It contains the amount of coffee, the unit of measurement, and whether it is decaf or not.
It has three constructors, one without parameters that sets the default values for the attributes, 
another that takes the amount of coffee as a parameter, and a third that takes both the amount of coffee and whether it is decaf as parameters.
*/

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.amount = amount;
        this.name = "Coffee";
        this.unit = Unit.GR;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

/**
 * Returns a string of the Coffee object.
 * @return a string of the Coffee object.
 */

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
