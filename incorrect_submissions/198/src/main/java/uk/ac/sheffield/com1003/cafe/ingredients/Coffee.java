package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);
    }

    public Coffee(int amount){
        this(amount ,false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }



    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == this) {
            return true;
        }
        if (!(another instanceof Coffee)) {
            return false;
        }
        Coffee c = (Coffee) another;

        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        return name.equals(((Ingredient)another).getName()) && this.unit.equals(c.unit) && this.amount==c.amount && this.decaf==c.decaf ;
    }
}


