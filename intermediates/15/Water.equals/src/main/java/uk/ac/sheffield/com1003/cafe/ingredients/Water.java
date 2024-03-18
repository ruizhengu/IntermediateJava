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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Water)) {
            return false;
        }
        Water other = (Water) obj;
        return this.getAmount() == other.getAmount() &&
                this.getUnit().equals(other.getUnit());
        }

}
