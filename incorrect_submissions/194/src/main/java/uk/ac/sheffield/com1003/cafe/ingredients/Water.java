package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * @author milan
 */
public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }

    public Water(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water)) {
            return false;
        }
        //compares attributes of this and another water
        return (((Water)another).getName() == getName() && ((Water)another).unit == unit
                && ((Water)another).getAmount() == getAmount());
    }
}
