package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    /**
     * Overload a constractor to customize the amount of coffee 
     * @param amount the ml of coffee
    */
    public Coffee(int amount){
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /** 
     * Override the equals to coffee
     * @param another is the compared coffee
     * @return true if two coffees are totally same
    */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;

        if (name.equals(((Coffee)another).getName()) &&
            amount == ((Coffee)another).getAmount() &&
                unit.equals(((Coffee)another).getUnit()) &&
                    decaf == ((Coffee)another).decaf ) {       
            return true;   
        }else{
            return false;
        }
    }
}
