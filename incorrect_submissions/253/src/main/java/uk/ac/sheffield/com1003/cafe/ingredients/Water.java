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
    public boolean equals(Object other) {
        // This method redirects .equals() of Ingredient Array elements to the correct method.
        if (other instanceof Water)
            return equals((Water)other);
        else
            return false;
    }

    public boolean equals(Water other) {
        return name == other.name
                && unit == other.unit
                && amount == other.amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
