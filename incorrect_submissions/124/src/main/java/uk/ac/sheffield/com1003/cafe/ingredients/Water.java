package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() { this(30); }

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
        // Check objects are the same type (null will return false here)
        if (!(another instanceof Water))
            return false;

        // Check specific instance variables
        Water anotherWater = (Water) another;
        return (name.equals(anotherWater.name) &&
                amount == anotherWater.amount &&
                unit == anotherWater.unit);
    }
}
