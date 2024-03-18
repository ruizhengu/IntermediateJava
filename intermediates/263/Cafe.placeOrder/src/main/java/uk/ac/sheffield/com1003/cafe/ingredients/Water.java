package uk.ac.sheffield.com1003.cafe.ingredients;
//Update Water constructor
public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.unit   = Unit.ML;
        this.name   = "Water";
    }
    // Overloaded Water constructor
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