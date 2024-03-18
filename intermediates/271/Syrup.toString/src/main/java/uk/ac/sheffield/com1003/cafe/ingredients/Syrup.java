package uk.ac.sheffield.com1003.cafe.ingredients;

/** The syrup ingredient. Task 6. */
public class Syrup extends Ingredient {
    String flavour;

    public Syrup() {
        this.flavour = "caramel";
        this.amount = 30;
    }

    public Syrup(String flavour) {
        this.flavour = flavour;
        this.amount = 30;
    }

    public Syrup(int amount) {
        this.flavour = "caramel";
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour +"]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return name.equals(((Syrup)another).getName())
            && flavour.equals(((Syrup)another).flavour)
            && amount == ((Syrup)another).amount
            && unit == ((Syrup)another).unit;
    }
}
