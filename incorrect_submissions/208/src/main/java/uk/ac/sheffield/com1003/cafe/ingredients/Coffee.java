package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * This class represents coffee.
 * It is a subclass of the Ingredient class.
 * It has attributes for its name, amount, unit and whether it is decaffeinated or not.
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Coffee)) {
            return false;
        }
        Coffee anotherCoffee = (Coffee) another;
        if (!name.equals(anotherCoffee.name)) {
            return false;
        }
        if (amount != anotherCoffee.amount) {
            return false;
        }
        if (decaf != anotherCoffee.decaf) {
            return false;
        }
        return true;
    }

}
