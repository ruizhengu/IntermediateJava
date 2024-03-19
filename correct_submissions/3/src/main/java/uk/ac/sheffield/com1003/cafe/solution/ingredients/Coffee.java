package uk.ac.sheffield.com1003.cafe.solution.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);
    }

    public Coffee(int amount) {
        // Task 1
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public boolean equals(Object another) {
        // Task 5 - Guard clause to check if same object type since.
        // Using getClass over instanceof for same reason as for recipe, no subclasses.
        if (another == null || another.getClass() != Coffee.class)
            return false;

        Coffee other = (Coffee) another;
        if (!name.equals(other.name)
            || unit != other.unit
            || amount != other.amount
            || decaf != other.decaf)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
