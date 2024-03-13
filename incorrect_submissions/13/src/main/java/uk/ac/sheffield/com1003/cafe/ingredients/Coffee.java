package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    /*constructor that sets the default coffee to 8gr and not decaf*/
    public Coffee() { this(8, false );}

    /*constructor that sets the amount to a given parameter and not decaf*/
    public Coffee(int amount) { this(amount, false);}

    /*constructor that sets the amount and decaf to parameters*/
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
}
