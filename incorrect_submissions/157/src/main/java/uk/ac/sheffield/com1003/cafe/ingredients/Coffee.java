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
     * Method for checking whether two Coffee objects are equal
     * 
     * @param comparison
     * @return True if both Coffee objects have the same instance variables
     */
    @Override
    public boolean equals(Object another) {
        if (another!=null && (another instanceof Coffee)) {
            Coffee comparison = (Coffee)another;
            if (this.name==comparison.name) {
                if (this.amount==comparison.amount) {
                    if (this.unit==comparison.unit) {
                        if (this.decaf==comparison.decaf) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
