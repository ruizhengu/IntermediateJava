package uk.ac.sheffield.com1003.cafe.ingredients;

public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;
    /**
     * Method that returns the name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method that returns the unit.
     */
    public Unit getUnit() {
        return this.unit;
    }
    /**
     * Method that returns the amount.
     */
    public int getAmount() {
        return this.amount;
    }
    /**
     * Method that returns all the instance information in a string.
     */
    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
