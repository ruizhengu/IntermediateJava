package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() { this(8, false); }

    public Coffee(int amount) { this(amount, false); }

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
        // Check objects are the same type (null will return false here)
        if (!(another instanceof Coffee))
            return false;

        // Check specific instance variables
        Coffee anotherCoffee = (Coffee) another;
        return (name.equals(anotherCoffee.name) &&
                amount == anotherCoffee.amount &&
                unit == anotherCoffee.unit &&
                decaf == anotherCoffee.decaf);
    }
}
