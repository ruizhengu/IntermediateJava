package uk.ac.sheffield.com1003.cafe.ingredients;

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
     * Compares the amount, unit and name of two ingredients which are in different recipes
     * @param another An ingredient from another recipe
     * @return true if the two ingredients being compared are the exact same
     */
    public boolean compare(Ingredient another) {
    	if (another == null || ! (another instanceof Ingredient))
            return false;
    	if (this.amount != another.amount || 
    			this.unit != another.unit ||
    			!this.name.equals(another.name))
    		return false;
    	
    	return true;
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
