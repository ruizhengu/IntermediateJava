package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    
    /**
     * Default constructor that sets the amount
     * to 10 and the flavour to "Vanilla".
     */
    public Syrup() {
        this(10, "Vanilla");
    }

    /**
     * Constructor that takes the flavour name
     * as a parameter and sets the amount of syrup to
     * the default value of 10.
     * @param flavour Flavour name
     */
    public Syrup(String flavour) {
        this(10, flavour);
    }

    /**
     * Constructor that takes as parameters the,
     * the ammount of syrup and the flavour name.
     * @param amount Amount of syrup
     * @param flavour Flavour name
     */
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
