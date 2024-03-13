package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean getDecaf() { return this.decaf; }
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /**
     * Overrides the equals method in ingredient
     *
     * @param another The object to compare this too
     *
     * @return True if the name of this object is equal to the name of the another object, if the unit of this object
     * is equal to the unit of the another object, if the amount of this object is equal to the amount of the another
     * object and if decaf of this object is equal to the decaf of the another object.
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Coffee)) {
            return false;
        } else {
            return this.name.equals(((Ingredient) another).getName())
                    && this.unit.equals(((Ingredient) another).getUnit())
                    && this.amount == ((Ingredient) another).getAmount()
                    && this.decaf == ((Coffee) another).getDecaf();
        }
    }
}


