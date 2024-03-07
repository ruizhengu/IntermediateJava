package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water (int amount) {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    public boolean equals (Object another) {
        if (super.equals(another) && another instanceof Water) {
            Water otherIngredient = (Water) another;
            return (unit.equals(otherIngredient.unit)
                    && amount == otherIngredient.amount);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
