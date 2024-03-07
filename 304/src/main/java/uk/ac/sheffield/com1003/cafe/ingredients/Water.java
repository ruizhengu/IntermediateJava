package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    //added by me
    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    /*
     * Overriding to check if param (water) is equal to object and the water ingredient is the same with the
     * recipe customer is asking, return false if the class is different
     * Compare if all the details such as amount, unit and name is the same, return true if everything is same
     */
    public boolean equals(Object water){
        if ( water == this ) {
            return true;
        }
        if ( water.getClass() != this.getClass() ) {
            return false;
        }
        Water waterCompared = (Water) water;
        if ( (waterCompared.amount == this.amount) && (waterCompared.unit == this.unit)
                && (waterCompared.name.equals(this.name)) ){
            return true;
        }

            return false;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
