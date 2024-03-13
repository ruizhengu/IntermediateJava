package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This class is used to instantiate Water objects.
 * Each water object inherits the attributes name, unit and amount
 * It also overrides toString and equals methods to make them more specific to Water objects
 */
public class Water extends Ingredient {

    /**
     * Default constructor for Water
     */
    public Water() {
        this(30);
    }

    /**
     * Another constructor for Water taking the amount as an input
     * @param amount the volume of water in millilitres
     */
    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    /**
     * Compares another object with this Water type object and returns whether they are the same
     * Overrides the equals method in the parent class
     *
     * @param another a pointer to the object that this object is being compared to
     * @return true if they are considered equal, false otherwise
     */

    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Water)) {
            return false;
        }
        else {
            Water otherIngredient = (Water)another;
            return (this.name.equals(otherIngredient.getName()) &&
                    this.amount == otherIngredient.getAmount() &&
                    this.unit == otherIngredient.getUnit());
        }
    }

    /**
     * A toString method overriding the one in the Ingredient superclass
     * @return a clear display of the relevant instance variables for this Water object
     */
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
