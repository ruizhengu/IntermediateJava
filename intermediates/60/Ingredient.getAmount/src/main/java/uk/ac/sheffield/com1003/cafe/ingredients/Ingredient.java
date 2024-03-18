package uk.ac.sheffield.com1003.cafe.ingredients;

public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;
    
    /**
     * getter method for name
     * @return ingredient name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * getter method for unit
     * @return ingredient unit
     */
    public Unit getUnit() {
        return this.unit;
    }
    
    /**
     * getter method for amount
     * @return ingredient amount
     */
    public int getAmount() {
        return this.amount;
    }
    
    /**
     * @return String explaining ingredient instance
     */
    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }
    
    /**
     * Checks whether two ingredient instances are the same
     * @return true if both instances have the same name
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
