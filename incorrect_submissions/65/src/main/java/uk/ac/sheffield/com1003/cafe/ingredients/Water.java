package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amountML) {
        this.name = "Water";
        this.amount = amountML;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        // super.equals compares ingredient name
        if (super.equals(another)) {
            Water anotherWater = (Water) another;

            // Compare data in each instance variable (unit, amount)
            return anotherWater.unit == this.unit &&
                    anotherWater.amount == this.amount;
        }

        return false;
    }
}
