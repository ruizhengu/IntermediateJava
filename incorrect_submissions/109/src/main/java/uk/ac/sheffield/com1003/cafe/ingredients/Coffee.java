package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);
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

    //Get methods for Coffee
    public boolean getDecaf() {
        return decaf;
    }

    /**
     * Checks whether two coffee objects are the same.
     * If both coffee objects have the same instance variables, they are the same coffee object.
     *
     * @param another
     * @return True if all the above criteria is met and false otherwise
     */
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        else if (name.equals(((Ingredient)another).getName())) {
            Coffee anotherCoffee = (Coffee) another;
            return this.getAmount() == anotherCoffee.getAmount() && this.getUnit() == anotherCoffee.getUnit()
                    && this.getDecaf() == anotherCoffee.getDecaf();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
