/**
 * Ingredient.java
 * This class is an abstract representation of an ingredient used in a cafe.
 * It has a name, unit, and amount, and provides methods to get and compare these properties.
 * @version 1.0 10/03/2023
 * @author Unknown
 */

package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Abstract class representing an ingredient used in a cafe, with a name, unit, and amount.
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
     * Returns string representation of Ingredient object, including its name, unit, and amount.
     * @return The string representation of the Ingredient object.
     */
    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }

    /**
     * Compares the name property of two Ingredient objects for equality.
     * @param another The object to compare with.
     * @return true if the name properties of both Ingredient objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
