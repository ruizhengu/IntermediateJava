/**
* Water.java
*
*
* 16/03/2023
*
* @author Mu'az bin Mohamad Nor Sazelim
*/

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof Water) {
            Water water2 = (Water) another;
            if (name.equals(water2.getName()) && unit.equals(water2.getUnit()) && amount == water2.getAmount()) {
                return true;
            }

            return false;
        }

        return false;
    }
}
