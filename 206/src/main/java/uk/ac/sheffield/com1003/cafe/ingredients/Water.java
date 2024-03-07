package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water(){
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount=30;
    }

    public Water(int amount) {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    public boolean equals(Object ingredient){
        if (ingredient == null || ! (ingredient instanceof Water)) {
            return false;
        } else {
            if (((Water) ingredient).name == name &&
                    ((Water) ingredient).amount == amount &&
                    ((Water) ingredient).unit == unit) {
                return true;
            } else {
                return false;
            }
        }
    }
}
