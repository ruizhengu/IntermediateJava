package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
         this(8);
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

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    public boolean equals(Coffee another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        return this.toString().equals(((Coffee)another).toString());
    }
}
