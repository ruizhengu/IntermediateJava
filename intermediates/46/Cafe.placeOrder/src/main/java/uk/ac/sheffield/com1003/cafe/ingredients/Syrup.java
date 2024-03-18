package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    // Syrup is string not enum so many flavours can be easily added
    // Base amount is 10ml and base flavour is Caramel
    // Varying levels of constructors exist to change flavour and amount
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.flavour= "Caramel";
        this.amount = 10;
        this.unit=Unit.ML;
    }

    public Syrup(String flavour){
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = 10;
        this.unit=Unit.ML;
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}