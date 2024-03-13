package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Syrup.java  12/03/2023
 * 
 * @author Lucas Madle
 */
public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Caramel");
    }

    public Syrup(String flavour) {
        this(8, flavour);
    } 

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }


    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other))
            return false;

        Syrup otherIngredient = (Syrup)other;
        return flavour == otherIngredient.getFlavour();
    }
}