package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.GR;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        if (another == null) {
            return false;
        }

        if (another instanceof Water) {
            Water otherWater = (Water) another;
            if (name == otherWater.getName()
                    && amount == otherWater.getAmount()
                    && unit == otherWater.getUnit()) {
                return true;

            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
