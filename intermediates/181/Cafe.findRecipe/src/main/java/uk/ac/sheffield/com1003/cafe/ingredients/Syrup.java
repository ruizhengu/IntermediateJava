package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    
    // Default constructor without any arguments
    public Syrup() {
        this.amount = 30;
        this.unit = Unit.ML;
        this.flavour = "Hazelnut";
    }

    // Constructors for private field Flavour and other instances variables
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
