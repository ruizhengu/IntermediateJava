package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This abstract class is used as a template for objects whose superclass is an Ingredient.
 * It declares that subclasses should have a name, unit and amount
 * It provides accessors for these variables and basic toString and equals methods which can be overridden
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

    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }

    /**
     * Compares this instance with another object to see if they are the same based on their names
     * @param another the other object
     * @return true if their names are the same, otherwise false
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
