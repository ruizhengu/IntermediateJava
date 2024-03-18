package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.amount = amount;
        this.unit = Unit.ML;
        this.name = "Water";
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        return name.equals(((Water)another).getName()) && amount == ((Water)another).getAmount() && unit == ((Water)another).getUnit();
    }
}
