package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() { //DEFAULT
        this.name = "Water"; //Step 1.1
        this.unit = Unit.ML;
        this.amount = 30;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
    public Water(int newAmount) { //Overload Step 1.2
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = newAmount;
    }

    //Override .equals
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }

}
