package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public String getFlavour() {
        return flavour;
    }

    public Syrup() {
        this(30, "Caramel");
    }

    public Syrup(int amount, String flavour) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;

        return (name.equals(((Ingredient)another).getName()) &&
                amount == ((Ingredient)another).getAmount() &&
                unit == ((Ingredient)another).getUnit() &&
                flavour.equals(((Syrup)another).getFlavour()));
    }
}


