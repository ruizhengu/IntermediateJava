package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public Water(int amount) {
        this.name = "water";
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
        if (name.equals(((Ingredient)another).getName()) && amount == (((Ingredient)another).getAmount()) && unit == (((Ingredient)another).getUnit())) {
            return true; 
        } else {
            return false;
        }
    }
}
