package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {
    /**
     * Constructor that initialises amount to 30.
     */
    public Water()
    {
        this(30);
    }
    /**
     * Constructor that takes amount as a parameter and sets name to Milk and unit to ML.
     */
    public Water(int amount)
    {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }
    /**
     * Method that returns all the instance information in a string.
     */
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
