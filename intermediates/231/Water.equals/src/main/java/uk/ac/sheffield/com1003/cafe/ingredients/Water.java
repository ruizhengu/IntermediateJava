package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() { this(30); }

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
     * Compares two Water objects to see if have equivalent data field values
     *
     * @param another Takes in another Water instance as an input value
     * @return Returns true if the name, amount and unit are the same; return false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        return this.name.equals(((Water)another).getName()) && this.amount == ((Water)another).getAmount() &&
                this.unit.equals(((Water)another).getUnit());
    }
}
