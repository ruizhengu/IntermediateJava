package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "water";
        this.unit = Unit.ML;
    	this.amount = 30;
    }
    
    public Water(int value) {
        this.name = "water";
        this.unit = Unit.ML;
    	this.amount = value ;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
