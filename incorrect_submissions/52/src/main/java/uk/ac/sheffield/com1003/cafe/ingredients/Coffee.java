package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8,false);
    }

    public Coffee(int amount) {
        this(amount,false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * Checks whether two coffee are the same.
     * @param coffee The coffee to be distinguished.
     * @return True if two coffee are the same amount, unit, name ,decaf option,
     * and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Coffee another = (Coffee) obj;

        return this.name.equals(another.getName()) && this.amount == another.getAmount()
             && this.decaf == another.decaf && this.unit ==another.unit;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
