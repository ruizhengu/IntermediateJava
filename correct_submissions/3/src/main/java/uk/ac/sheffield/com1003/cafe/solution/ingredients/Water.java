package uk.ac.sheffield.com1003.cafe.solution.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        // Task 1
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    @Override
    public boolean equals(Object another) {
        // Task 5 - Guard clause to check if same object type since.
        // Using getClass over instanceof for same reason as for recipe, no subclasses.
        if(another == null || another.getClass() != Water.class)
            return false;

        Water other = (Water) another;
        if(!name.equals(other.name) || unit != other.unit || amount != other.amount)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
