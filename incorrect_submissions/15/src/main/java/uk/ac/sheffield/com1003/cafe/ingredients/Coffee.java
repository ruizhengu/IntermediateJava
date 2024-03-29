package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.name = "Coffee";        
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.amount = amount;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
        
    }
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

        /**

    Overrides the equals() method to compare Coffee objects based on their amount, unit, and dcaf.
    @param obj The object to compare to this Coffee object.
    @return true if the objects are equal based on their amount, unit, and dcaf, false otherwise.
    */

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coffee)) {
            return false;
        }
        Coffee other = (Coffee) obj;
        return this.amount == other.amount &&
               this.unit == other.unit &&
               this.decaf == other.decaf;
    }
}

