package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        return super.equals(another);
    }
}
