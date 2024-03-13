package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Constructor that initialises ingredient name to "Coffee", amount
     * to 8, unit to {@link Unit} GR, and decaf to false.
     */
    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    /**
     * Constructor that takes the amount and decaf as parameters and
     * initialises ingredient name to "Coffee",
     * unit to {@link Unit} GR, and decaf to false.
     */
    public Coffee(int amount, boolean decaf) {
        this();
        this.amount = amount;
        this.decaf = decaf;
    }

    /**
     * Constructor that takes the amount as a parameter and
     * initialises ingredient name to "Coffee",
     * unit to {@link Unit} GR, and decaf to false.
     */
    public Coffee(int amount) {
        this();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    public boolean equals(Object another) {
        super.equals(another);
        if (another == null || !(another instanceof Coffee)) {
            return false;
        }
        Coffee anotherCoffee = (Coffee) another;
        if (anotherCoffee.name == this.name && anotherCoffee.amount == this.amount
                && anotherCoffee.unit == this.unit && anotherCoffee.decaf == this.decaf) {
            return true;
        }
        return false;
    }
}
