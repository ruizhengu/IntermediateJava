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

    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }

    @Override //checks for name and amount
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (name.equals(((Ingredient)another).getName()))
        {
            if (this.amount == ((Ingredient)another).getAmount()) 
                return true;
        }
        return false;
    }
}
