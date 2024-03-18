package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    //default constructor
    public Coffee() {
        this(8, false);
    }

    /**
     * Amount only overload
     * @param amount
     */
    public Coffee(int amount){
        this(amount, false);
    }

    /**
     * Fully definable constructor
     * @param amount
     * @param decaf
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = decaf;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /**
     * Checks whether a passed in object is an ingredient of the same
     * type, and has the same instance variable values
     * @param other The object being compared with
     * @return Returns true if the passed in ingredient matches this instance
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        Coffee coffee = (Coffee) another;
        return name.equals(coffee.getName()) && amount == coffee.amount && unit == coffee.unit && decaf == coffee.decaf;
    }
}
