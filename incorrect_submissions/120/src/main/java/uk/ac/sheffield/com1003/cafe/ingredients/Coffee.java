package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * The Coffee class extends the Ingredient class to provide
 * extra functionality by using a private decaf variable.
 *
 * @author Yusuf Ibn Saifullah
 * @since 12-03-2023
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object o2) {
        if (o2.getClass() != Coffee.class) {
            return false;
        }
        Coffee c2 = (Coffee) o2;
        // compares all the parameters of milk
        if (this.amount == c2.amount && this.name == c2.name && this.unit == c2.unit && this.decaf == c2.decaf)
            return true;
        else
            return false;
    }
}
