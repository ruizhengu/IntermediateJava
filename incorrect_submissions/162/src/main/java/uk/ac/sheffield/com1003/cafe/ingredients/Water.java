package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {
    public Water() {
        this(30);
    }

    public Water(int i) {
        this.amount = 30;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
