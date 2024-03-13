package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    public boolean getDecaf() {
        return decaf;
    }


    /**
     * Two coffees are equal if they have the same name, amount, unit and decaf
     * 
     * @param another the Coffee object to compare to
     * @return true if the two coffees are equal, false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee)){
            return false;
        }

        Coffee anotherCoffee = (Coffee)another;
        if (anotherCoffee.getName().equals(this.name) && anotherCoffee.getAmount() == this.amount 
        && anotherCoffee.getUnit() == this.unit && anotherCoffee.getDecaf() == this.decaf) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
