package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup[Flavour='" + flavour + ", Unit=" + unit + ", Amount=" + amount + "]";
    }
}
