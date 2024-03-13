package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";       //Overloading Coffee constructor so a coffee object can be made without passing anything into the method
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }
    
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;       //Overloading the coffee constructor again so the instance variable decaf can be changed
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    public boolean equals(Coffee another) {
        boolean check = true;       //Overriding the equals method in ingredient.java to check if the decaf instance variable is the same in two coffee objects
        if (decaf != another.decaf) {
            check = false;
        }
        return check;
    }
}
