package uk.ac.sheffield.com1003.cafe.solution.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    
    /**
     * Constructor that initialises flavour to "Caramel", amount
     * to 30, name to Syrup and unit to ML.
     */
    public Syrup() {
        this("Caramel");
    }
    
    /**
     * Constructor that takes flavour as a parameter and initialises amount
     * to 30, name to Syrup and unit to ML.
     */
    public Syrup(String flavour) {
        this(30, flavour);
    }
    
    /**
     * Constructor that takes flavour and amount as a parameter and initialises
     * name to Syrup and unit to ML.
     */
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    
    public boolean equals(Object objectTwo) {
        if ( objectTwo == this)
            return true;
        if ( objectTwo == null || this.getClass() != objectTwo.getClass() ) 
            return false;
        Syrup syrupTwo = (Syrup)objectTwo;
        // convert object to syrup type and compare instance variables
        if (name.equals(syrupTwo.name) && unit == syrupTwo.unit && amount == syrupTwo.amount && 
                flavour.equals(syrupTwo.flavour))
            return true;
        return false;
    }
}
