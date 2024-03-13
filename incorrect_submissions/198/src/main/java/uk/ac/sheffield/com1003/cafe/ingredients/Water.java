package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit=Unit.ML;
    }

    public Water(int amount){
        this.amount=amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == this) {
            return true;
        }
        if (!(another instanceof Water)) {
            return false;
        }
        Water w = (Water) another;

        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }

        return this.unit.equals(w.unit) && this.amount==w.amount;
    }
}
