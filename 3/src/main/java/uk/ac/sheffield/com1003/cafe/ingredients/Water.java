package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.unit = Unit.ML;
    }
    public Water(int amount){
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    /**
     * compares 2 objects and returns wether they are equal in their values 
     * 
     * @param ingredentTwo ingredient to compare against the first
     * @return boolean whether they are equal or not
     */
    @Override
    public boolean equals(Object ingredientTwo){
        if (ingredientTwo == null || ! (ingredientTwo instanceof Water))
            return false;
        Water waterTwo = (Water)ingredientTwo;
        return name.equals(waterTwo.getName()) && amount == waterTwo.amount && unit.equals(waterTwo.getUnit());
    }
}
