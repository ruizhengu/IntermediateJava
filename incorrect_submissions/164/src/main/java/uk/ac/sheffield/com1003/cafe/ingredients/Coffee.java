package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This class is used to instantiate Coffee objects.
 * As well as the inherited name, unit and amount, coffee objects have the attribute decaf
 * It also overrides toString and equals methods to make them more specific to Coffee objects
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Default constructor for Coffee
     */
    public Coffee() {
        this(8, false);
    }

    /**
     * Another constructor for Coffee taking the amount as an input
     * @param amount the mass of coffee in grams
     */
    public Coffee(int amount) {
        this(amount, false);
    }

    /**
     * Another constructor for Coffee taking the amount and whether the coffee is decaf as inputs
     * @param amount the mass of coffee in grams
     * @param decaf whether the coffee contains no caffeine
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean getDecaf() { return decaf; }

    /**
     * Compares another object with this Coffee type object and returns whether they are the same
     * Overrides the equals method in the parent class
     *
     * @param another a pointer to the object that this object is being compared to
     * @return true if they are considered equal, false otherwise
     */

    @Override
    public boolean equals(Object another){
        if (!(another instanceof Coffee)) {
            return false;
        }
        else {
            // Cast "another" to a Coffee object so that we can call getDecaf() on it
            Coffee otherIngredient = (Coffee)another;
            return (this.name.equals(otherIngredient.getName()) &&
                    this.amount == otherIngredient.getAmount() &&
                    this.unit == otherIngredient.getUnit() &&
                    this.decaf == otherIngredient.getDecaf());
        }
    }

    /**
     * A toString method overriding the one in the Ingredient superclass
     * @return a clear display of the relevant instance variables for this Coffee object
     */
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
