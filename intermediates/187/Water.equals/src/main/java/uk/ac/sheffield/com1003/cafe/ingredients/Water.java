package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() { //DEFAULT
        this.name = "Water"; //Step 1.1
        this.unit = Unit.ML;
        this.amount = 30;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
    public Water(int newAmount) { //Overload Step 1.2
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = newAmount;
    }

    //Override .equals
    public boolean equals(Object myObj) {
        if (!(myObj instanceof Water)) {
            return false; //Not a Water
        }
        Water otherWater = (Water) myObj;
        if (name.equals(otherWater.name) && amount==otherWater.amount && unit==otherWater.unit) {
            return true;
        } else {
            return false;
        }
    }

}
