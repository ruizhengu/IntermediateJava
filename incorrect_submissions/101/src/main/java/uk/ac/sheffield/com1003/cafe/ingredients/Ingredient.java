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

    /**
     * update the equals methods to check name,
     * unit and amount to be equal
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (!name.equals(((Ingredient) another).getName())){
            return false;
        }
        if (unit != ((Ingredient) another).getUnit()){
            return false;
        }
        if (amount != ((Ingredient) another).getAmount()){
            return false;
        }
        return true;
    }
}
