/**
* Coffee.java
*
*
* 16/03/2023
*
* @author Mu'az bin Mohamad Nor Sazelim
*/

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof Coffee) {
            Coffee coffee2 = (Coffee) another;
            if (name.equals(coffee2.getName()) && amount == coffee2.getAmount() && unit.equals(coffee2.getUnit()) && decaf == coffee2.decaf) {
                return true;
            }

            return false;
        }

        return false;
    }
}
