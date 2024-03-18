package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("caramel");
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 10;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * [Task 5] Override of the equals method allowing custom instance variables to be compared
     * @param another
     * @return True if the objects are equal
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return name.equals(((Syrup)another).getName())
                && unit == ((Syrup) another).getUnit()
                && amount == ((Syrup) another).getAmount()
                && flavour == ((Syrup) another).getFlavour();
    }
}