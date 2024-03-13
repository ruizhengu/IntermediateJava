package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Syrup))
            return false;
        return this.getUnit().equals(((Syrup) another).getUnit()) && this.getAmount() == ((Syrup) another).getAmount()
                && this.getName().equals(((Syrup) another).getName());
    }
}
