package uk.ac.sheffield.com1003.cafe.ingredients;

import java.security.PrivateKey;

public class Water extends Ingredient {
    private String name;
    private int amount;
    private Unit unit;

    public Water() {
        this.amount = getAmount();
        this.name = "Water";
        this.unit = Unit.ML;
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
}
