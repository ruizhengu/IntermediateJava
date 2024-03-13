package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;


    public Syrup() {
        this.name = "Syrup";
        this.amount = 5;
        this.flavour = "hazelnut";
        this.unit = Unit.ML;
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = 5;
        this.unit = Unit.ML;
    }

    public Syrup(int amount) {
        this.name = "Syrup";
        this.amount = amount;
        this.flavour = "hazelnut";
        this.unit = Unit.ML;
    }

    public String getFlavour() {
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Syrup))
            return false;
        return name.equals(((Ingredient) another).getName())
                && amount == ((Ingredient) another).getAmount()
                && unit == ((Ingredient) another).getUnit()
                && flavour == ((Syrup) another).getFlavour();

    }
}
