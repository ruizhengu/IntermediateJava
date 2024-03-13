package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf = false;

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount) {
        this.amount = amount;
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
    public boolean equals(Object otherCoffee) {
        if (otherCoffee instanceof Coffee && unit.equals(((Coffee)otherCoffee).unit))
            return true;
        else 
            return false;
    }
}
