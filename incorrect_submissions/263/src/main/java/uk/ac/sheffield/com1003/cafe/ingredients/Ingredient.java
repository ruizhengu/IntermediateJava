package uk.ac.sheffield.com1003.cafe.ingredients;

public abstract class Ingredient {
    protected String name = "";
    protected Unit unit = Unit.UNDEFINED;
    protected int amount;

    public String getName() {
        return this.name;
    }

    /**
     *
     * add setName method to update Ingredient's name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return this.unit;
    }

    /**
     *
     * add setUnit method to update Unit variable.
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return this.amount;
    }

    /**
     *
     * add setAmount method to update amount variable.
     */
    public void setAmount(int amount) {
        this.amount = amount;
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

