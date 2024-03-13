package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    //Task 5
    //Create getDecaf() to know if its decaf or no
    public boolean getDecaf() {
        return decaf;
    }

    public Coffee() {
        this.amount = 8;
    }

    //Task 1
    //Overload the constructor
    public Coffee(int amount) {
        this.amount = amount;
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

    //Task 5
    //Use override equals() to let this run only for Coffee.java
    @Override
    public boolean equals(Object another) {
        boolean all = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (name.equals(((Ingredient)another).getName()))
            if (unit.equals(((Ingredient)another).getUnit()))
                if (amount == ((Ingredient)another).getAmount())
                    if (decaf == ((Coffee)another).getDecaf())
            all = true;
        return all;
    }
}