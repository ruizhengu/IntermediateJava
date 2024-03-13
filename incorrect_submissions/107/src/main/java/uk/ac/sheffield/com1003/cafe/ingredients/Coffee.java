/**
 * Coffee.java
 *
 * @version 1.0 15/03/2023
 * @author Naseem Hoque
 */

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount) {
        this.amount = amount;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    /**
     * Overrides equals() method to compare instance variables of the Coffee.java class
     *
     * @param another Ingredient to be compared to
     * @return True is the ingredients are identical; returns false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Coffee))
            return false;
        return super.equals(another) && amount == ((Coffee) another).amount && decaf == ((Coffee) another).decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
