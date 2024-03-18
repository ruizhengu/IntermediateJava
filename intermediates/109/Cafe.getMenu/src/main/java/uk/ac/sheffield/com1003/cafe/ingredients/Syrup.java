package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Strawberry");
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 13;
        this.flavour = flavour;
    }

    //Get methods for Syrup
    public String getFlavour() {
        return flavour;
    }

    /**
     * Checks whether two syrup objects are the same
     * If both syrup objects have the same instance variables, they are the same syrup object.
     *
     * @param another
     * @return True if all the above criteria is met and false otherwise
     */
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        if (name.equals(((Ingredient)another).getName())) {
            Syrup anotherSyrup = (Syrup) another;
            return this.getUnit() == anotherSyrup.getUnit() && this.getAmount() == anotherSyrup.getAmount()
                    && this.getFlavour().equals(anotherSyrup.getFlavour());
        }
        return false;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
