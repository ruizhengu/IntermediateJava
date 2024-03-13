package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Vanilla");
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 10;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    /**
     * Getter for syrup flavour
     * @return Syrup flavour
     */
    public String getFlavour() {
        return flavour;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    public boolean equals(Object o) {

        /* If statement below will try to Cast parameter into Syrup
        * Otherwise, will return false
        */
        if (o == null || ! (o instanceof Syrup))
            return false;
        Syrup syrup = (Syrup)o;

        /*Sequence below stores equivalence of Class attributes
        * Then returns false if any are not equal
        */
        boolean sameName = (this.name == syrup.name);
        boolean sameAmount = (this.amount == syrup.amount);
        boolean sameUnit = (this.unit == syrup.unit);
        boolean sameFlavour = (this.flavour.toLowerCase().equals(syrup.flavour.toLowerCase()));

        if (!sameName || !sameAmount || !sameUnit || !sameFlavour) {
            return false;
        }
        
        return true;
    }
}
