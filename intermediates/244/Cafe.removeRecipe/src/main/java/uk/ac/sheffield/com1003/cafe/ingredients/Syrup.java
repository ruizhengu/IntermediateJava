package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour, Unit unit, int amount) {
        super();
        this.flavour = flavour;
    }

    public Syrup(String flavour) {
        this(flavour, Unit.ML, 0);
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}
