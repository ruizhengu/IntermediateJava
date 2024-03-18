package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    /**
     * Creates a new instance of the Water ingredient
     * @see Water#Water(int amount)
     */
    public Water() {
        this(30);
    }
    /**
     * Creates a new instance of the Water ingredient
     * @param amount Amount of water in ml
     * @see Water#Water()
     */
    public Water(int amount){
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object other){
        // Handle edge cases
        if (!(other instanceof Water))
            return false;
        if (this == other)
            return true;
        // Handle super values
        boolean equal = super.equals(other);
        // Handle instance variables
        Water otherWater = (Water) other;
        return equal && (amount == otherWater.getAmount()
                        && unit == otherWater.getUnit());
    }
}
