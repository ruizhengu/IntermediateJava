package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * The Ingredient class is an abstract class that represents an ingredient used in drinks.
 */
public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;

    public String getName() {
        return this.name;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public int getAmount() {
        return this.amount;
    }

    /**
     * Returns a string representation of the Ingredient object.
     *
     * @return a string representation of the Ingredient object
     */
    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }

    /**
     * Determines whether this Ingredient object is equal to another object.
     *
     * @param another the object to compare to this Ingredient object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
