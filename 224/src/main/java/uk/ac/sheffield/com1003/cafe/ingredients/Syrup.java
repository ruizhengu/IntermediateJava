package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(){
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = "Vanilla";
    }

    public Syrup(int amount) {
        this.amount = amount;
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + "amount=" + amount + "flavour=" + flavour + "]";
    }
}
