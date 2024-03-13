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
    public boolean equals(Object oWater) {
        if (this == oWater)
            return true;
        if (oWater == null || getClass() != oWater.getClass())
            return false;

        Water water = (Water) oWater;
        if (water.amount==this.amount && water.name==this.name && water.unit == this.unit)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
