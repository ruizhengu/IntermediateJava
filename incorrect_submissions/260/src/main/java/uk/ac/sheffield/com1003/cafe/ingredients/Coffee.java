package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.function.ObjDoubleConsumer;

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

    /**
     * Getter for coffee decaf
     * @return Coffee decaf
     */
    public boolean getDecaf() {
        return decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    public boolean equals(Object o) {
        
        /* If statement below will try to Cast parameter into Coffee
        * Otherwise, will return false
        */
        if (o == null || ! (o instanceof Coffee))
            return false;
        Coffee coffee = (Coffee)o;

        /*Sequence below stores equivalence of Class attributes
        * Then returns false if any are not equal
        */
        boolean sameName = (this.name == coffee.name);
        boolean sameAmount = (this.amount == coffee.amount);
        boolean sameUnit = (this.unit == coffee.unit);
        boolean sameDecaf = (this.decaf == coffee.decaf);

        if (!sameName || !sameAmount || !sameUnit || !sameDecaf) {
            return false;
        }

        return true;
    }
}
