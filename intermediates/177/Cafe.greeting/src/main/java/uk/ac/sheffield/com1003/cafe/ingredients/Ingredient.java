package uk.ac.sheffield.com1003.cafe.ingredients;

public abstract class Ingredient {
    public String name = "";
    public Unit unit = Unit.UNDEFINED;
    public int amount;

//    public Ingredient(String unit2, double amount2) {
//    }

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
