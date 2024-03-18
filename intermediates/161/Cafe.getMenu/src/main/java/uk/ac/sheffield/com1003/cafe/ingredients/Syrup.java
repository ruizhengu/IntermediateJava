package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    /**
     * Constructor that initialises flavour to "Maple", amount
     * to 10 and unit to {@link Unit} ML.
     */
    public Syrup() {
        this.flavour = "Maple";
        this.unit = Unit.ML;
        this.amount = 10;
    }

    /**
     * Constructor that takes the flavour as parameter initialises flavour to "Maple", amount
     * to 10 and unit to {@link Unit} ML.
     */
    public Syrup(String flavour) {
        this(); // calls the default syrup constructor to pre-populate fields
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    public boolean equals(Object another) {
        super.equals(another);
        if (another == null || !(another instanceof Syrup)) {
            return false;
        }
        Syrup anotherSyrup = (Syrup) another;
        if (anotherSyrup.flavour == this.flavour && anotherSyrup.amount == this.amount
                && anotherSyrup.unit == this.unit) {
            return true;
        }
        return false;
    }


}
