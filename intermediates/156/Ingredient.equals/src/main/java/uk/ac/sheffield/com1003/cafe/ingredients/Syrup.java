package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public String getFlavour() { return this.flavour; }
    public Syrup() { this(5, "toffee"); }
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
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
        boolean flavourMatch = this.getFlavour()  == ((Syrup) ingredient2).getFlavour();
        return (unitsMatch && amountMatch && flavourMatch);
    }

    @Override
    public String toString() { return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]"; }
}
