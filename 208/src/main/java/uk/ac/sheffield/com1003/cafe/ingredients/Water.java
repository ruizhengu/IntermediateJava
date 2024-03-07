package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * This class represents water.
 * It is a subclass of the Ingredient class.
 * It has attributes for its name, amount and unit.
 */
public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Water)) {
            return false;
        }
        Water anotherWater = (Water) another;
        if (!name.equals(anotherWater.name)) {
            return false;
        }
        if (amount != anotherWater.amount) {
            return false;
        }
        return true;
    }
}
