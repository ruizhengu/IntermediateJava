package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
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

    /**
     * Compares the Water to the specified object to determine if they are equal.
     *
     * @param another
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Water))
            return false;
        Water otherWater = (Water) another;
        if(this.name!= otherWater.name)
            return false;
        if (this.amount != otherWater.amount)
            return false;
        if(this.unit != otherWater.unit)
            return false;
        return true;
    }
}
