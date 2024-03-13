package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.amount = 8;
        this.decaf = false;
    }

    public Coffee(int amount){
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

    //Compares two Coffee objects to see if they have the same name, unit, amount, and decaf status.
    @Override
    public boolean equals(Object another) {
        // Check if the other object is an instance of the Coffee class
        if (another instanceof Coffee) {

            // Cast the other object to a Coffee object and store it in a variable
            Coffee otherCoffee = (Coffee) another;

            // Compare the name, unit, amount, and decaf status of the two Coffee objects
            if (name.equals(otherCoffee.getName()) && unit.equals((otherCoffee.getUnit())) && amount == otherCoffee.getAmount()
                    && decaf == otherCoffee.decaf) {
                return true;
            }
            // If any of the properties are not equal, return false
            return false;
        }
        // If the other object is not a Coffee object, return false
        return false;
    }
}


