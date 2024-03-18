package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    /**
     * Two waters are equal if they have the same name, amount and unit
     * 
     * @param another the Water object to compare to
     * @return true if the two waters are equal, false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water)){
            return false;
        }

        Water anotherWater = (Water)another;
        if (anotherWater.getName().equals(this.name) && anotherWater.getAmount() == this.amount 
        && anotherWater.getUnit() == this.unit){
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
