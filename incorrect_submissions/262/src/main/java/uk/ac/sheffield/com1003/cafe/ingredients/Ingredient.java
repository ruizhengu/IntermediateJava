package uk.ac.sheffield.com1003.cafe.ingredients;

public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;

    /**
     * Getter for name of ingredient
     * @return name of ingredient
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for measurement units of ingredient
     * @return measurement unit of ingredient
     */
    public Unit getUnit() {
        return this.unit;
    }

    /**
     * Getter for amount of ingredient
     * @return amount of ingredient
     */
    public int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }

    
    /**
     * boolean checking if two objects are ingredients
     * and if they have the same name
     * @return true if both ingredients with the same name
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
