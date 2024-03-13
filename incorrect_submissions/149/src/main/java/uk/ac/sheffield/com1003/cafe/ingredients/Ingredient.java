
package uk.ac.sheffield.com1003.cafe.ingredients;

public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;

    public Ingredient(String name, Unit unit) {
        this.name = name;
        this.unit = unit;
    }

    public Ingredient() {
    }

    // getters and setters

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public int getAmount() {
        return this.amount;
    }

    public abstract double getPrice();

    public String toString() {
        return "Ingredient [name=" + name + ", unit=" + unit + ", amount=" + amount + "]";
    }

    public boolean equals(Object another) {
        if (another == null || !(another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient) another).getName());
    }

}