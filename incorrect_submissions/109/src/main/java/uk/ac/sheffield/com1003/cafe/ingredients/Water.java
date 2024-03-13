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

    /**
     * Checks whether two water objects are the same.
     * If both water objects have the same instance variables, they are the same water object.
     *
     * @param another
     * @return True if all the above criteria is met and false otherwise
     */
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        else if (name.equals(((Ingredient)another).getName())) {
            Water anotherWater = (Water) another;
            return this.getAmount() == anotherWater.getAmount() && this.getUnit() == anotherWater.getUnit();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
