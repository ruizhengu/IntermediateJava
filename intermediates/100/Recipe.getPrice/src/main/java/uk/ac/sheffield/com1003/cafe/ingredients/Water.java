package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    public Water(int amount){
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
