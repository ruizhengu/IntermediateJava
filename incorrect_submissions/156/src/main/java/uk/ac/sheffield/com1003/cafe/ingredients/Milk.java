package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Type getMilkType() { return this.type; }
    public Milk() {
        this(100, Type.WHOLE);
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
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
        boolean milkTypeMatch = this.getMilkType()  == ((Milk) ingredient2).getMilkType();
        return (unitsMatch && amountMatch && milkTypeMatch);
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
