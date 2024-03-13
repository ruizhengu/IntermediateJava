package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour, String unit, double amount) {
//        super(unit, amount);
        this.flavour = flavour;
    }

    public Syrup(String flavour) {
        this(flavour, "ml", 10.0);
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}

