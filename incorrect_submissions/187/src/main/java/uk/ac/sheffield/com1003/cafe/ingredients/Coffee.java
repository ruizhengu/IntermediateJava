package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() { //DEFAULT
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false; //Decaf by default (Step 1.1)
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount; //Overload (Step 1.2)
        this.unit = Unit.GR;
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

    //Override .equals
    public boolean equals(Object myObj) {
        if (!(myObj instanceof Coffee)) {
            return false; //Not a Coffee
        }
        Coffee otherCoffee = (Coffee) myObj;
        if (name.equals(otherCoffee.name) && amount==otherCoffee.amount && unit==otherCoffee.unit && decaf==otherCoffee.decaf) {
            return true;
        } else {
            return false;
        }
    }

}
