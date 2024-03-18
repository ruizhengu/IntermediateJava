package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    //default constructor
    public Coffee() {
        this(8, false);
    }

    /**
     * Amount only overload
     * @param amount
     */
    public Coffee(int amount){
        this(amount, false);
    }

    /**
     * Fully definable constructor
     * @param amount
     * @param decaf
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = decaf;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /**
     * Checks whether a passed in object is an ingredient of the same
     * type, and has the same instance variable values
     * @param other The object being compared with
     * @return Returns true if the passed in ingredient matches this instance
     */
    @Override
    public boolean equals(Object other){

        if (!(other instanceof Coffee)){
            return false;
        }

        Coffee otherCoffee = ((Coffee)other);

        if(!name.equals(otherCoffee.getName())){
            return false;
        }
        if(!unit.equals(otherCoffee.getUnit())){
            return false;
        }
        if(decaf != otherCoffee.decaf){
            return false;
        }
        if(amount != otherCoffee.getAmount()){
            return false;
        }

        return true;
    }
}
