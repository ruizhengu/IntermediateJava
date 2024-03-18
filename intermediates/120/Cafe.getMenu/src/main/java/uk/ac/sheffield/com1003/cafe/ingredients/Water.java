package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * The Water class extends the Ingredient class to provide
 * extra functionality by overriding both toString and the equals class.
 *
 * @author Yusuf Ibn Saifullah
 * @since 12-03-2023
 */
public class Water extends Ingredient {

    public Water() {
        // Call other constructor
        this(30);
    }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }
}
