package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public boolean getDecaf() {
        return decaf;
    }

    public Coffee() {
        this.amount = 8;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean equals(Coffee coffee) {
        //checks to see if all values are the same and if so returns true
        if (this.name == coffee.getName() && this.amount == coffee.getAmount()
            && this.unit == coffee.getUnit() && this.decaf == coffee.getDecaf()) {
            System.out.println(coffee);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
