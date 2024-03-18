package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;
    /**
     * Constructor that initialises amount to 8.
     */
    public Coffee()
    {
        this(8);
    }
    /**
     * Constructor that takes amount as a parameter and sets name to Coffee, unit to GR and decaf to false.
     */
    public Coffee(int amount)
    {
        this.amount = amount;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }
    /**
     * Constructor that takes amount and boolean decaf as parameters and sets name to Coffee, unit to GR and
     * decaf to false.
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    /**
     * Method that returns all the instance information in a string.
     */
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
