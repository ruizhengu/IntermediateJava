/**
* Syrup.java
*
*
* 16/03/2023
*
* @author Mu'az bin Mohamad Nor Sazelim
*/

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = "rose";
    }

    public Syrup(String flavour) {
        this();
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + this.getUnit() + ", amount=" + this.getAmount() + ", flavour=" + this.flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof Syrup) {
            Syrup syrup2 = (Syrup) another;
            if (unit.equals(syrup2.getUnit()) && amount == syrup2.getAmount() && flavour.equals(syrup2.flavour)) {
                return true;
            }

            return false;
        }

        return false;
    }
}
