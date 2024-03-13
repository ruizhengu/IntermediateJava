package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This is an abstract class, extended by classes Water, Coffee, Milk, 
 * and Syrup.
 */

public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;

    /**
     * Getter for ingredient name
     * @return ingredient name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for ingredient unit
     * @return ingredient unit
     */
    public Unit getUnit() {
        return this.unit;
    }

    /**
     * Getter for ingredient amount
     * @return ingredient amount
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * @return Returns a string representation of the ingredient in
     * the format "Ingredient [name=<name>, unit=<unit>, amount=<amount>]"
     */
    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" +
                amount + "]";
    }

    /**
     * Checks whether another ingredient is the same as this ingredient
     * @param another Ingredient to be checked
     * @return True if ingredient name is the same and false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
