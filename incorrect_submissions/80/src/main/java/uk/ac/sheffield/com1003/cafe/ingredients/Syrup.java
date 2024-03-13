package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    //default constructor
    public Syrup() {
        this.flavour = "Maple Syrup";
        this.unit = Unit.ML;
        this.amount = 20;
    }

    public Syrup(String flavour, int amount) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }


    @Override
    public boolean equals(Object another) {
        return super.equals(another);
    }
}
