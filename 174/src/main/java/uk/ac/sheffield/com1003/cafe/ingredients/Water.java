package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    /**
     * Constructor that takes the amount of 30
     * for water.
     */
    public Water() {
        this.amount = 30;
    }

    /**
     * Constructor that takes the amount of
     * water as parameters and gives it in ml unit.
     */
    public Water(int amount){
        this.amount = amount;
        this.unit = Unit.ML;
    }

    /**
     * @return Returns a string representation of the water in
     * the format "Water [unit=<unit>, amount=<amount>]"
     */
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
