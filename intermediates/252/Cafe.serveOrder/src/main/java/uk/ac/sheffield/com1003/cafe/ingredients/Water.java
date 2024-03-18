package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public Water(int amount){
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
