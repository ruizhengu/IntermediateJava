package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    /**
     * A constructor which constructs of new instance of syrup class
     * @param flavour
     */
    public Syrup (String flavour){
        this.flavour=flavour;
        this.unit = Unit.ML;
        this.amount = 0;
    }

    /**
     * Constructor which takes chocolate as the default flavour
     */
    public Syrup(){
        this.flavour = "chocolate";
        this.unit = Unit.ML;
        this.amount = 0;
    }
    @Override
    public String toString(){
        return "Syrup [unit= "+unit+ ",amount = "+amount+ ",flavour = "+flavour+ "]";
    }

    /**
     * Compares the syrup to the specified object to determine if they are equal.
     *
     * @param another The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Syrup))
            return false;
        Syrup otherSyrup = (Syrup) another;
        if (this.flavour != otherSyrup.flavour)
            return false;
        if (this.unit != otherSyrup.unit)
            return false;
        if (this.amount!= otherSyrup.amount)
            return false;
        return true;
    }
}
