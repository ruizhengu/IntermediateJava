package uk.ac.sheffield.com1003.cafe.solution.ingredients;

/**
 * Task 6 and Task 5 - Create a new subclass of Ingredients called Syrup that has a constructor
 * that sets the flavour as a String as its unique attribute.
 *
 * @version 1.3
 * @since 0.6
 * @author unknown
 */
public class Syrup extends Ingredient {
    private String flavour;

    /**
     * Default Constructor for Syrup. Sets flavour to Strawberry and amount to 10 by default.
     * Calls <code>Syrup(String flavour)</code>
     */
    public Syrup() {
        this("Strawberry");
    }

    /**
     * Constructor that sets the flavour to user input and amount to 10.
     * Calls <code>Syrup(int amount, String flavour)</code>
     * @param flavour the name of the flavour
     */
    public Syrup(String flavour) {
        this(10, flavour);
    }

    /**
     * Constructor that sets the flavour and amount to user input
     * @param amount amount of syrup in ml
     * @param flavour the name of the flavour
     */
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }
    @Override
    public boolean equals(Object another) {
        // Task 5 - Guard clause to check if same object type since.
        // Using getClass over instanceof for same reason as for recipe, no subclasses.
        if(another == null || another.getClass() != Syrup.class)
            return false;

        Syrup other = (Syrup) another;
        if(!name.equals(other.name)
            || unit != other.unit
            || amount != other.amount
            || !flavour.equals(other.flavour))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount +", flavour=" + flavour  +  "]";
    }
}
