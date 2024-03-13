package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.unit = Unit.ML;
        this.name = "Water";
    }
    
    public Water(int amount) { //Added in for Task 1
        this.amount = amount; 
        this.unit = Unit.ML;
        this.name = "Water";
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
