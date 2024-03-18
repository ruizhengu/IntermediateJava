package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Strawberry");
    }

    public Syrup (String flavour) {
        this(5, flavour);
    }

    public Syrup(int amount) {
        this(amount, "Strawberry");
    }

    public Syrup (int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public boolean equals(Object another) {
        if (super.equals(another) && another instanceof Syrup) {
            Syrup otherIngredient = (Syrup) another;
            return (unit.equals(otherIngredient.unit)
                    && amount == otherIngredient.amount
                    && flavour.equals(otherIngredient.flavour));
        }
        return false;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
