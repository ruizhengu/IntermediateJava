package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup() {
        this.amount = 30;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "Golden";
    }
    public Syrup(String flavour) {
        this.amount = 30;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() { return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]"; }

    @Override
    public boolean equals(Object another){
        if (another == null || ! (another instanceof Syrup))
            return false;

        Syrup otherSyrup = (Syrup) another;
        if(this.amount == otherSyrup.amount && this.flavour == otherSyrup.flavour) return true;
        else return false;
    }
}
