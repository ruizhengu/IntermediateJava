package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * The abstract Ingredient class is used as a base class
 * to have basics of ingredients such as name, unit and amount.
 *
 * @author Yusuf Ibn Saifullah
 * @since 12-03-2023
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
        if (another == null || !(another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient) another).getName());
    }
}
