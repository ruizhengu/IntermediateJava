package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    /**
     * Constructor that initialises amount to 10 and flavour to "Caramel"
     */
    public Syrup() {this(10, "Caramel");}
    /**
     * Constructor that initialises amount to 10 and takes the flavour as parameters
     */
    public Syrup(String flavour) {
        this(10, flavour);
    }
    /**
     * Constructor that takes the amount and flavour as parameters
     */
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    /**
     * Check if two objects are the same.
     * @param Object another to add a recipe to compare
     * @return True if another object is syrup and all parameters are same
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Syrup)) return false;
        Syrup syrup = (Syrup) another;
        return name.equals(syrup.getName()) &&
                unit.equals(syrup.getUnit()) &&
                amount == syrup.getAmount() &&
                flavour == syrup.flavour;
    }
}
