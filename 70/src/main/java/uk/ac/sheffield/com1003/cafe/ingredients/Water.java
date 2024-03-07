package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water anotherToWater = (Water)another;
        return (name.equals(anotherToWater.getName()) && unit == anotherToWater.getUnit()
                && amount == anotherToWater.getAmount());
    }
}
