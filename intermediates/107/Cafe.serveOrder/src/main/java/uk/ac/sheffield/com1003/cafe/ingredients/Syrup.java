/**
 * Syrup.java
 *
 * @version 1.0 15/03/2023
 * @author Naseem Hoque
 */

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Vanilla", 5, (Unit.ML));
    }

    public Syrup(String flavour, int amount, Unit unit) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    /**
     * Overrides equals() method to compare instance variables of the Syrup.java class
     *
     * @param another Ingredient to be compared to
     * @return True is the ingredients are identical; returns false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Syrup)) return false;
        return super.equals(another) && amount == ((Coffee) another).amount && flavour.equals(((Syrup) another).flavour);
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}

