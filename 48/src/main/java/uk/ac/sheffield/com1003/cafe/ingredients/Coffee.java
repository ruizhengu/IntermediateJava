package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    //Constructor that takes the amount of coffee as a parameter.
    public Coffee(int amount){
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    @Override
    public boolean equals(Object other){
        if (other == null || ! (other instanceof Coffee))
            return false;
        return name.equals(((Coffee)other).getName())
            && super.unit == ((Coffee)other).getUnit()
            && super.amount == ((Coffee)other).getAmount()
            && this.decaf == ((Coffee)other).decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
