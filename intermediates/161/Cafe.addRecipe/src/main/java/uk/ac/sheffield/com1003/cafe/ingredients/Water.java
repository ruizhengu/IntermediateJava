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
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }
}
