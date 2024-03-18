package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    // Expended all constructors to be uniform and easier to understand
    // Base quantity of coffee is 8gr, with decaf as false
    // Two additional layers of constructors exist to modify amount and decaf

    public Coffee() {
        this.name= "Coffee";
        this.amount = 8;
        this.unit=Unit.GR;
        this.decaf = false; 
    }

    public Coffee(int amount){
        this.name = "Coffee";
        this.amount = amount;
        this.unit=Unit.GR;
        this.decaf = false;
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
}
