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

    /**
     * Checks whether two water are the same.
     * @param water The coffee to be distinguished.
     * @return True if two coffee are the same amount, unit, name,
     * and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Water another = (Water) obj;

        return this.name.equals(another.getName()) && this.amount == another.getAmount()
             && this.unit == another.unit;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
