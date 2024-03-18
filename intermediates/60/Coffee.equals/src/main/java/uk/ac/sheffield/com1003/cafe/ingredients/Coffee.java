package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;
    
    /**
     * Constructor that initialises amount to 8, and decaf to false.
     */
    public Coffee() {
        this(8, false);
    }
    
    /**
     * Constructor that takes coffee amount as a parameter,
     * initialises decaf to false.
     */
    public Coffee(int amount) {
        this(amount, false);
    }
    
    /**
     * Constructor that takes coffee amount and decaf as parameters,
     * initialises name to Coffee, and unit to GR.
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    
    /**
     * getter for decaf
     * @return True if decaf
     */
    public boolean getDecaf() {
        return decaf;
    }
    
    /**
     * Checks whether two Coffee instances are the same
     * @return true if both instances are identical
     */
    public boolean equals(Object another) {
        if (another == null ||
                ! (another instanceof Ingredient) ||
                ! (amount == ((Ingredient)another).getAmount()) ||
                ! (decaf == ((Coffee)another).getDecaf()))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
    
    /**
     * @return a String explaining the particular Coffee instance
     */
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
