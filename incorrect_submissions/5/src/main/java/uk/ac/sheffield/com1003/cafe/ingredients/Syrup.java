package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    // Task 6

    private String flavour;

    public Syrup() {
        this(5, "Vanilla");
    }

    public Syrup(int amount) {
        this(amount, "Vanilla");
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }  
}
