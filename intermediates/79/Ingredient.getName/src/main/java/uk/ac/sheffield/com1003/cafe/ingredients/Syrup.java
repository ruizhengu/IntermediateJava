package uk.ac.sheffield.com1003.cafe.ingredients;

//Task 6
//Create Syrup.java, extend from Ingredient.java, make everything similar to milk, water, coffee
public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(int amount, String flavour) {
        this.amount = amount;
        this.flavour = flavour;
    }

    public Syrup(int amount) {
        this.amount = amount;
        flavour = "Caramel";
    }

    public Syrup() {
        this.name = "Syrup";
        this.amount = 5;
        this.unit = Unit.ML;
        this.flavour = "Caramel";
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        boolean all = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (name.equals(((Ingredient)another).getName()))
            if (unit.equals(((Ingredient)another).getUnit()))
                if (amount == ((Ingredient)another).getAmount())
                    if (flavour == ((Syrup)another).getFlavour())
            all = true;
        return all;
    }
}