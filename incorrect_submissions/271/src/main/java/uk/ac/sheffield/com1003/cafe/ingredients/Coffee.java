package uk.ac.sheffield.com1003.cafe.ingredients;

/** The coffee ingredient. */
public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
        this.name = "Coffee";
    }

    public Coffee(int amount) {
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
        this.name = "Coffee";
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

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        return name.equals(((Coffee)another).getName())
            && decaf == ((Coffee)another).decaf
            && amount == ((Coffee)another).amount
            && unit == ((Coffee)another).unit;
    }
}
