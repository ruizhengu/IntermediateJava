package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    
    /**
     * Constructor that initialises amount to 10 and flavour to Vanilla.
     */
    public Syrup() {
        this("Vanilla", 10);
    }
    
    /**
     * Constructor that takes flavour as parameter,
     * initialises amount to 10.
     */
    public Syrup(String flavour) {
        this(flavour, 10);
    }
    
    /**
     * Constructor that takes amount and flavour as parameters,
     * initialises name to Syrup, and unit to ML.
     */
    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = amount;
    }
    
    /**
     * @return a String explaining the particular Syrup instance
     */
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}

