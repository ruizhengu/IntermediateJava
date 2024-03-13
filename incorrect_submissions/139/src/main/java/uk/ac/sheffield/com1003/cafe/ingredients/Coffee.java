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
     * Checks whether two coffee objects have the same attribute values.
     *
     * @param i Ingredient to compare to
     * @return true if equal, otherwise false
     */
    public boolean equals(Ingredient i){
        if (i instanceof Coffee) {
            if (this.getName() != i.getName()) {
                return false;
            } else if (this.decaf != ((Coffee) i).getDecaf()) {
                return false;
            } else if (this.amount != i.getAmount()){
                return false;
            } else if (this.unit != i.getUnit()){
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public Coffee(int amount) {
    	this.amount = amount;
    }

    public boolean getDecaf(){
        return decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
