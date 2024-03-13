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
    public boolean equals(Object o2) {
        if (o2.getClass() != Water.class) {
            return false;
        }
        Water w2 = (Water) o2;
        // compares all the parameters of water
        if (this.amount == w2.amount && this.name == w2.name && this.unit == w2.unit)
            return true;
        else
            return false;
    }
}
