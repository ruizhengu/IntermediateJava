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
    public boolean equals(Object water) {
        if (water == this) {
            return true;
        }

        if (!(water instanceof Water)) {
            return false;
        }

        Water nWater = (Water) water;
        if (this.name.equals(nWater.name) && 
        this.unit == nWater.unit &&
        this.amount == nWater.amount) {
            return true;
        } else {
            return false;
        }
    }
}
