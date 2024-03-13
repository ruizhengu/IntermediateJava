package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * Water is a subclass of Ingredient that represents water used in drinks.
 * It can be measured in milliliters.
 */
public class Water extends Ingredient {

    /**
     * Constructs a new Water object with a default amount of 30 milliliters.
     */
    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    /**
     * Constructs a new Water object with the specified amount.
     *
     * @param amount the amount of water, in milliliters
     */
    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (! (another instanceof Water)) {
            return false;
        }

        Water otherWater = (Water) another;
        return this.name.equals(otherWater.name) && this.unit.equals(otherWater.unit)
                && this.amount == otherWater.amount;
    }
}
