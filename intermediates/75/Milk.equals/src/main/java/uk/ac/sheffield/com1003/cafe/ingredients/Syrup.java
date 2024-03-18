package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    /**
     * Constructs an instance of Syrup using the default values for each instance variable
     */
    public Syrup() {
        this("Vanilla", "Vanilla", Unit.ML, 5);
    }

    /**
     * Constructs an instance of Syrup using a sepcified value for flavour and the default 
     * values for the other instance variables
     * @param flavour The flavour of the syrup
     */
    public Syrup(String name, String flavour) {
        this(name, flavour, Unit.ML, 5);
    }

    /**
     * Constructs an instance of Syrup using specified values for each instance variable
     * @param flavour The flavour of the syrup
     * @param unit The unit of measurement for the syrup
     * @param amount The amount of syrup
     */
    public Syrup(String name, String flavour, Unit unit, int amount) {
        this.name = name;
        this.flavour = flavour;
        this.unit = unit;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Syrup [name=" + this.name + ", unit=" + this.unit + ", amount=" + this.amount 
            + ", flavour=" + this.flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup)) {
            return false;
        }
        else {
            Syrup otherIngredient = (Syrup)another;
            if (this.name == otherIngredient.getName() && this.unit == otherIngredient.getUnit() 
                && this.amount == otherIngredient.getAmount()) {
                    
                return true;
            }
        }

        return false;
    }
}
