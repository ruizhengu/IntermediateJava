package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() { this(8, false); }

    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.amount = amount;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /**
     * Compares two Coffee objects to see if have equivalent data field values
     *
     * @param another Takes in another Coffee instance as an input value
     * @return Returns true if the name, amount, unit and {@link Coffee#decaf} are the same; return false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        return this.name.equals(((Coffee)another).getName()) && this.amount == ((Coffee)another).getAmount() &&
                this.unit.equals(((Coffee)another).getUnit()) && this.decaf == ((Coffee)another).decaf;
    }
}
