package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This class represents Coffee which is a type of Ingredient.
 * It has three constructors; the first takes no parameters and sets the
 * amount to 8, the second takes an int and boolean as parameters and sets 
 * the amount and decaf accordingly, and the third takes an int as 
 * parameter and sets the amount accordingly.
 * It overrides the toString method defined in Ingredient.
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
    }

    public Coffee(int amount, boolean decaf) {
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee (int amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
