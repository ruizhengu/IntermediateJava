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


    /**
     * Check if two objects are the same.
     * @param Object another to add a recipe to compare
     * @return True if another object is water and all parameters are same
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Water)) return false;
        Water water = (Water) another;
        return name.equals(water.getName()) &&
                unit.equals(water.getUnit()) &&
                amount == water.getAmount();
    }
}
