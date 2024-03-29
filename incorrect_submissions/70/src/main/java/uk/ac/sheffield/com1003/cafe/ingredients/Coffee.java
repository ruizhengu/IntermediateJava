package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.amount = 8;
        this.decaf = false;
    }

    public Coffee(int amount){
        this.amount = amount;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        Coffee anotherToCoffee = (Coffee)another;
        return (name.equals(anotherToCoffee.getName()) && unit == anotherToCoffee.getUnit()
                && amount == anotherToCoffee.getAmount() && this.decaf == anotherToCoffee.decaf);
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
