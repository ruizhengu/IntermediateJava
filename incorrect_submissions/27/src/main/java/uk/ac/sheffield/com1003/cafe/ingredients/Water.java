package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }
    
    public Water(int amount) {
        this.amount = amount;
        this.unit = Unit.ML;
        this.name = "Water";
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
