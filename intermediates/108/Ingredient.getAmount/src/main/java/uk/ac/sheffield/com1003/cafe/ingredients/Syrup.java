package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    public Syrup(String name, int amount, String flavour) {
        this.name = name;
        this.amount = amount;
        this.flavour = flavour;

    }

    public Syrup(String flavour) {
        this.flavour = flavour;
    }

@Override
public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}

