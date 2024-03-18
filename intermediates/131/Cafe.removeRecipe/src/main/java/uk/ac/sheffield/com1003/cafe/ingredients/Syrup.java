package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Hazelnut");
    }

    public Syrup(String flavour) {
        this.flavour = flavour;
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    public boolean equals(Syrup syrup) {
        if (this == syrup) {
            return true;
        }
        return false;
    }
}
