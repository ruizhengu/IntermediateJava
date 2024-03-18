package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * 
 * Coffee class represents a type of ingredient that can be used to make a
 * recipe.
 * It extends the Ingredient class and adds an additional property, decaf, which
 * 
 * indicates whether the coffee is decaffeinated or not.
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amountOfCoffee) {
        this.amount = amountOfCoffee;
    }

    @Override
    public String toString() {
        return ("Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]");
    }
}
