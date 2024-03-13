package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class Water extends Ingredient {

    /**
     * Default constructor
     */
    public Water() {
        this(30);
    }

    /**
     * Fully definable constructor
     * @param amount
     */
    public Water(int amount){
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    /**
     * Checks whether a passed in object is an ingredient of the same
     * type, and has the same instance variable values
     * @param other The object being compared with
     * @return Returns true if the passed in ingredient matches this instance
     */
    @Override
    public boolean equals(Object other){

        if (!(other instanceof Water)){
            return false;
        }

        Water otherWater = ((Water)other);

        if(!name.equals(otherWater.getName())){
            return false;
        }
        if(!unit.equals(otherWater.getUnit())){
            return false;
        }

        if(amount != otherWater.getAmount()){
            return false;
        }
        return true;
    }
}
