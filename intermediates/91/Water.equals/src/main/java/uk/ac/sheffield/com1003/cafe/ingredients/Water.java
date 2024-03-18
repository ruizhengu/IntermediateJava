package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
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
     * Compares whether two objects are equal
     * @return True if both objects are Water objects with equal variables, false otherwise
     */
    public boolean equals(Object otherObject)
    {
        if (otherObject == null) { return false; }
        if (!(otherObject instanceof  Ingredient)) { return false; }
        if (this.getClass() != otherObject.getClass()) { return false; }
        Ingredient tempIngredient = (Ingredient) otherObject;
        if (this.getName() != tempIngredient.getName()) { return false; }

        Water tempWater = (Water) otherObject;
        if (tempWater != null && tempWater instanceof Ingredient && this.unit == tempWater.unit
                && this.amount == tempWater.amount) { return true; }
        else { return false; }
    }

}
