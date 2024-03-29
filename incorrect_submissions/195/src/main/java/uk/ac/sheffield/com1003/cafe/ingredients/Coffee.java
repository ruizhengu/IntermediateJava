package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    public Coffee(int amount){
        this(amount,false);
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /**
     * Compares the coffee to the specified object to determine if they are equal.
     *
     * @param another
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object another){
        if (another == null || ! (another instanceof Coffee))
            return false;
        Coffee otherCoffee = (Coffee) another;
        if (this.amount!= otherCoffee.amount)
            return false;
        if (this.unit != otherCoffee.unit)
            return false;
        if (this.decaf != otherCoffee.decaf)
            return false;
        if (this.name != otherCoffee.name)
            return false;
        return true;
    }

}
