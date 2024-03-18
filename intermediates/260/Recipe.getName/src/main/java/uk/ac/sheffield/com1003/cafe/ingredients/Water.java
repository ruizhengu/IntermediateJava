package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
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

    public boolean equals(Object o) {

        /* If statement below will try to Cast parameter into Water
        * Otherwise, will return false
        */
        if (o == null || ! (o instanceof Water))
            return false;
        Water water = (Water)o;
        
        /*Sequence below stores equivalence of Class attributes
        * Then returns false if any are not equal
        */
        boolean sameName = (this.name == water.name);
        boolean sameAmount = (this.amount == water.amount);
        boolean sameUnit = (this.unit == water.unit);

        if (!sameName || !sameAmount || !sameUnit) {
            return false;
        }
        
        return true;
    }
}
