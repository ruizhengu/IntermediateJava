package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
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
        if (water instanceof Water) {
            Water anotherWater = (Water) water;
            if (this.name == anotherWater.name && this.amount == anotherWater.amount && this.unit == anotherWater.unit)
                return true;
            else return false;
        }else return false;
    }
}
