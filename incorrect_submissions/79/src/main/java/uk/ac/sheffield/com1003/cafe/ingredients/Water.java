package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    //Task 1
    //Overload the constructor
    public Water(int amount) {
        this.amount = amount;
    }

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    //Task 5
    //Use override equals() to let this run only for Water.java
    @Override
    public boolean equals(Object another) {
        boolean all = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (name.equals(((Ingredient)another).getName()))
            if (unit.equals(((Ingredient)another).getUnit()))
                if (amount == ((Ingredient)another).getAmount())
            all = true;
        return all;
    }
}
