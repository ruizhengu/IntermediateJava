package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
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
     * Find recipe with same instance and compare it to the object method is called from
     * @param another object being compared
     * @return Returns true if it is the same class and all variables are the same; false otherwise
     */
    @Override
    public boolean equals(Object another) {
        //check if class is the same
        if (super.equals(another)) {
            Coffee other = (Coffee) another;
            //compare variables
            if (this.getName() == other.getName()
                    && this.amount == other.amount
                    && this.unit == other.unit
                    && this.decaf == other.decaf ){

                return true;
            }
        }
        return false;
    }
}
