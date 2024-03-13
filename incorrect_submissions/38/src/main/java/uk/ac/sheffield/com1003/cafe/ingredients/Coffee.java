package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    public boolean isDecaf(){
        return decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        return amount == ((Coffee)another).getAmount() && (((Coffee)another).isDecaf() == decaf);
    }
}

