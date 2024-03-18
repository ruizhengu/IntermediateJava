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
     * checks if the ingredients have the same instances of their variables
     * @param ingredient2 ingredient to be compared with
     * @return True if the variables are the same; return false otherwise
     */
    public boolean ingredientVariablesMatch(Ingredient ingredient2) {
        boolean unitsMatch = this.getUnit() == ingredient2.getUnit();
        boolean amountMatch = this.getAmount() == ingredient2.getAmount();
        return (unitsMatch && amountMatch);
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
