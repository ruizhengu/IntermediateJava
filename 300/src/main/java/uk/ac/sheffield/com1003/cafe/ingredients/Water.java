package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = Unit.GR;
    }
    public Water(int amount) {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.GR;
    }
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
