package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
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

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return name.equals(((Ingredient)another).getName());
    }
}
