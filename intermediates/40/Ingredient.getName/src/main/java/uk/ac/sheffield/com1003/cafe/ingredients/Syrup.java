package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    public String flavour;
    public Syrup() {
        this("Maple", 50);
    }
    public Syrup(String flavour) {
        this(flavour, 50);
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit="+getUnit()+", amount="+getAmount()+", flavour="+flavour+"]";
    }
}
