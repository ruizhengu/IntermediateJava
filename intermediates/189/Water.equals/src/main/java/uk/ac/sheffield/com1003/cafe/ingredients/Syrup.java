package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    /* Constructor with no parameters, sets default values */
    public Syrup() {
        this.name = "Syrup";
        this.amount = 20;
        this.unit = Unit.ML;
        this.flavour = "Chocolate";
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 20;
        this.unit = Unit.ML;
        this.flavour = flavour;    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /* Method to return true if two syrup objects are the same */
    @Override
    public boolean equals(Object another) {
        if (another == null || getClass() != another.getClass())
            return false;
        /* If the class is the same, each  specific attribute is compared */
        Syrup anotherSyrup = (Syrup) another;
        if (this.getName() == anotherSyrup.getName()) {
            if (this.getAmount() == anotherSyrup.getAmount()) {
                if (this.getUnit() == anotherSyrup.getUnit()) {
                    if (this.flavour == anotherSyrup.flavour) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
