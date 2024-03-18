package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }


    /**
     * Compares this Water object with another object to see if they have the same name, unit, and amount.
     * @param another the object to compare with this Water object
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }
}
