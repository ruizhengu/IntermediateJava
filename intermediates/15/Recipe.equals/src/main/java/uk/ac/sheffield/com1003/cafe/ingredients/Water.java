package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    public Water(int amount) {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    /**

    Overrides the equals() method to compare Water objects based on their amount, unit.
    @param obj The object to compare to this Water object.
    @return true if the objects are equal based on their amount, unit, false otherwise.
    */

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }

}
