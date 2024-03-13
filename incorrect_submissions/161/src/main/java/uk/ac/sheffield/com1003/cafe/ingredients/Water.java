package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    /**
     * Constructor that initialises ingredient name to "Water",
     * amount to 30 and unit to {@link Unit} ML.
     */
    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    /**
     * Constructor that takes the amount as a parameter and
     * initialises ingredient name to "Water"
     * and unit to {@link Unit} ML.
     */
    public Water(int amount) {
        this();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    public boolean equals(Object another) {
        super.equals(another);
        if (another == null || !(another instanceof Water)) {
            return false;
        }
        Water anotherWater = (Water) another;
        if (anotherWater.name == this.name && anotherWater.amount == this.amount && anotherWater.unit == this.unit) {
            return true;
        }
        return false;

    }
}
