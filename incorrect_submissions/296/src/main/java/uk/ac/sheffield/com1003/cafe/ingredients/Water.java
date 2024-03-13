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
     * Overrides the equals method in ingredient
     *
     * @param another The object to compare this too
     *
     * @return True if the name of this object is equal to the name of the another object, if the unit of this object
     * is equal to the unit of the another object and if the amount of this object is equal to the amount of the another
     * object.
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Water)) {
            return false;
        } else {
            return this.name.equals(((Ingredient) another).getName())
                    && this.unit.equals(((Ingredient) another).getUnit())
                    && this.amount == ((Ingredient) another).getAmount();
        }
    }
}
