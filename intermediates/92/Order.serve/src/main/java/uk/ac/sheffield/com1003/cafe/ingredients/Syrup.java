package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup(String flavour) {
        this.flavour = flavour;
    }

    public Syrup() {
        this("vanilla"); // sets default flavour to vanilla
        this.unit = Unit.ML;
        this.amount = 55;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}
