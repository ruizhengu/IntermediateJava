package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour) {
       
        this.flavour = flavour;
    }

    public Syrup() {
        this("vanilla"); // set default flavour
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}


