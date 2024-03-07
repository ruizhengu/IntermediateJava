package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean getDecaf(){
        return this.decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        boolean same = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        //comparing name, amount, Unit and decaf of another Ingredient object
        if (name.equals(((Ingredient)another).getName()) && amount == ((Ingredient)another).getAmount() && unit.equals(((Ingredient)another).getUnit()) && decaf == (((Coffee)another).getDecaf()))
            same = true;
        return same;
    }
}
