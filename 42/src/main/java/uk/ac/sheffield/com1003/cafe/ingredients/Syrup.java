package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    /**
     * constructor that initialises the flavour as a default 'Sweet',
     * the amount as 15, the unit as ML and the name as 'Syrup'
     */
    public Syrup() {
        this("Sweet", 15);
    }

    /**
     * constructor that initialises the flavour as the parameter,
     * the amount as 15, the unit as ML and the name as 'Syrup'
     * 
     * @param flavour the user's desired flavour
     */
    public Syrup(String flavour) {
        this(flavour, 15);
    }
    
    /**
     * constructor that initialises the flavour and amount as 
     * the parameter, the unit as ML and the name as 'Syrup'
     * 
     * @param flavour the user's desired flavour
     * @param amount the user's desired amount
     */
    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit = " + unit + ", amount = " + amount + ", flavour = " + flavour + "]";
    }
}
