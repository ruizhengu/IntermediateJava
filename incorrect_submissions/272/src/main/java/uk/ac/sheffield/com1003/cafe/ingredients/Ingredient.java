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

    @Override
    public boolean equals(Object another) {
        Ingredient anotherObj = (Ingredient) another;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return (name.equals(anotherObj.getName()) && unit.equals(anotherObj.getUnit()) && 
        amount == anotherObj.getAmount()); // Compare Ingredient: name, unit and amount
    }
}
