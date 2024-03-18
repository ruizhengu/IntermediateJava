package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    /**
     * Constructor that initialises the default amount to 30
     */
    public Water() {this(30);}

    /**
     * Constructor that takes in amount of water as a parameter
     * Initialises name, amount, and sets default unit to ML
     * @param amount The amount of coffee
     */
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
     * equals() method to compare two water objects
     * Checks if the two objects are the same class, amount, and unit
     * @param o The object passed into the parameter of the method, to be compared
     * @return True is returned if class, amount and unit are the same, or false is returned otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }
}
