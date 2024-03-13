package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    /* Constructor with no parameters, sets default values */
    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    /* Constructor for specified amount of coffee */
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

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /* Method to return true if two coffee objects are the same */
    @Override
    public boolean equals(Object another) {
        if (another == null || getClass() != another.getClass())
            return false;
        /* If the class is the same, each  specific attribute is compared */
        Coffee anotherCoffee = (Coffee) another;
        if (this.getName() == anotherCoffee.getName()) {
            if (this.getAmount() == anotherCoffee.getAmount()) {
                if (this.getUnit() == anotherCoffee.getUnit()) {
                    if (this.decaf == anotherCoffee.decaf) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
