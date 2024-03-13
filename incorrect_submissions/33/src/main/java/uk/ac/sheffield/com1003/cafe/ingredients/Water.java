package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    private boolean hot;

    public Water() {
        this.amount = 30;
    }

    public Water(int amount, boolean hot) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.GR;
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
