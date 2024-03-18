package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount) {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        boolean same = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        //comparing name, amount and Unit of another Ingredient object
        if (name.equals(((Ingredient)another).getName()) && amount == ((Ingredient)another).getAmount() && unit.equals(((Ingredient)another).getUnit()))
            same = true;
        return same;
    }
}
