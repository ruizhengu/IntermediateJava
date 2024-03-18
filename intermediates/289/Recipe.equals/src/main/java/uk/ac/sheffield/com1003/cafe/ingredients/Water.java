package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = Unit.ML;

    }
    
    public Water(int amount){
        this.amount = amount;
        this.name = "water";
        this.unit = Unit.ML;
        
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    // Overriding equals method from superclass Ingredient (needed for task 5)
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }
}
