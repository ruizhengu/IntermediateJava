package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }
    /**
     * constructor takes arguments to construct object
     * @param amount    
     * @param decaf
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /**
     * compares 2 objects and returns wether they are equal in their values 
     * 
     * @param ingredentTwo ingredient to compare against the first
     * @return boolean whether they are equal or not
     */
    @Override
    public boolean equals(Object ingredientTwo){
        if (ingredientTwo == null || ! (ingredientTwo instanceof Coffee))
            return false;
        Coffee coffeTwo = (Coffee)ingredientTwo;
        return name.equals(coffeTwo.getName()) && amount == coffeTwo.amount && unit.equals(coffeTwo.getUnit()) && decaf == coffeTwo.decaf;
    }
   
}
