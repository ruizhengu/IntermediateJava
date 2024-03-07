package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() { this(30); }

    public Water(int amount){ this(amount, Unit.ML); }

    public Water(int amount, Unit unit){
        this.name = "Water";
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
