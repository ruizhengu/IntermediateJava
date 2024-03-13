package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 12;
        this.flavour = "Golden Syrup";
    }
    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 12;

    }

    /**
     * To string method which represents the Syrup object as a string.
     * @return The syrup object as a string.
     */
    @Override
    public String toString() { return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";}

    @Override
    public boolean equals(Object anotherObject) {
        if (!(anotherObject instanceof Syrup)) {
            return false;
        }
        Syrup aDifferentSyrupObject = (Syrup) anotherObject;
        return this.flavour == aDifferentSyrupObject.flavour;
    }
}

