package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * Coffee is a subclass of Ingredient that represents a type of coffee used in drinks.
 * It can be measured in grams and can be decaf or regular.
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Constructs a new Coffee object with a default amount of 8 grams and regular caffeine.
     */
    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    /**
     * Constructs a new Coffee object with the specified amount and regular caffeine.
     *
     * @param amount the amount of coffee, in grams
     */
    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    /**
     * Constructs a new Coffee object with the specified amount and caffeine type.
     *
     * @param amount the amount of coffee, in grams
     * @param decaf true if the coffee is decaf, false otherwise
     */
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
        if (! (another instanceof Coffee)) {
            return false;
        }

        Coffee otherCoffee = (Coffee) another;
        return this.name.equals(otherCoffee.name) && this.unit.equals(otherCoffee.unit)
                && this.amount == otherCoffee.amount && this.decaf==otherCoffee.decaf;
    }
}
