package uk.ac.sheffield.com1003.cafe.ingredients;

public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;


    /**
     * ingredient name getter
     * @return ingredient name
     */
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
     * @return return string representation of an ingredient in the format
     * "Ingredient [name=" + <ingredient name> + ", unit=" + <ingredient unit> + ", amount=" + <ingredient amount> + "]"
     */
    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }


    /** 
     * @param Object a java object that we check is an ingredient and if it has the same name as the other ingredent we are checking
     * @return whether the objects are equal
    */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
