package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() { //DEFAULT
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false; //Decaf by default (Step 1.1)
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount; //Overload (Step 1.2)
        this.unit = Unit.GR;
        this.decaf = false;
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

    //Override .equals
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        Coffee coffee = (Coffee) another;
        return name.equals(coffee.getName()) && amount == coffee.amount && unit == coffee.unit && decaf == coffee.decaf;
    }

}
