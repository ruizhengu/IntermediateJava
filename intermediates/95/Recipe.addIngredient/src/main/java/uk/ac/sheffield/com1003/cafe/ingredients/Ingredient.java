package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This abstract class defines the properties and methods of an Ingredient object.
 * It includes properties such as a name, unit, and amount. 
 * It also includes methods such as getName(), getUnit(), getAmount(), toString(), and equals().
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

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
