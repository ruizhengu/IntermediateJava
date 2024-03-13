package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * Water is a class that represents water as an ingredient in a recipe.
*/
public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = Unit.ML;
    }
    public Water(int amountOfWater){
        this.amount=amountOfWater;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
