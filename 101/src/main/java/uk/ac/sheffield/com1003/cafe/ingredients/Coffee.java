package uk.ac.sheffield.com1003.cafe.ingredients;
public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    /**
     * Constructor that takes amount as parameter, and
     * initialises name to Coffee and unit to GR.
     */
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
     * update the equals methods to check name,
     * unit, decaf and amount to be equal
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (!name.equals(((Ingredient) another).getName())){
            return false;
        }
        if (unit != ((Ingredient) another).getUnit()){
            return false;
        }
        if (amount != ((Ingredient) another).getAmount()){
            return false;
        }
        if (another instanceof Coffee){
            if (decaf !=((Coffee) another).decaf){
                return false;
            }
        }
        return true;
    }
}
