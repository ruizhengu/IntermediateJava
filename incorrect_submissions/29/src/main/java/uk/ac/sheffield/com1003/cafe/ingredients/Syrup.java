package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Caramel");
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 5;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        
        Ingredient ingredient = (Ingredient) another;

        if (this.getName() == ingredient.getName() &&
        this.getAmount() == ingredient.getAmount() &&
        this.getUnit() == ingredient.getUnit()) {
            return true;
        }
        else {
            return false;
        }
    }
}
