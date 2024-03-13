package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    private boolean getDecaf() { return this.decaf; }

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * checks if the ingredients have the same instances of their variables
     * @param ingredient2 ingredient to be compared with
     * @return True if the variables are the same; return false otherwise
     */
    @Override
    public boolean ingredientVariablesMatch(Ingredient ingredient2) {
        boolean unitsMatch = this.getUnit() == ingredient2.getUnit();
        boolean amountMatch = this.getAmount() == ingredient2.getAmount();
        boolean decafMatch = this.getDecaf()  == ((Coffee) ingredient2).getDecaf();
        return (unitsMatch && amountMatch && decafMatch);
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
