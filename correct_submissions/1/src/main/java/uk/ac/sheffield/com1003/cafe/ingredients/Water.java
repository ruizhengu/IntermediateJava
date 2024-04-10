package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
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

    @Override
    public boolean equals(Object objectTwo) {
        if (objectTwo == this)
            return true;
        if (objectTwo == null || this.getClass() != objectTwo.getClass())
            return false;
        // convert object to water type and compare instance variables
        Water waterTwo = (Water) objectTwo;
        if (name.equals(waterTwo.name) && unit == waterTwo.unit && amount == waterTwo.amount)
            return true;
        return false;
    }

    public boolean equalsSolution(Object objectTwo) {
        if (objectTwo == this)
            return true;
        if (objectTwo == null || this.getClass() != objectTwo.getClass())
            return false;
        // convert object to water type and compare instance variables
        Water waterTwo = (Water) objectTwo;
        if (name.equals(waterTwo.name) && unit == waterTwo.unit && amount == waterTwo.amount)
            return true;
        return false;
    }
}
