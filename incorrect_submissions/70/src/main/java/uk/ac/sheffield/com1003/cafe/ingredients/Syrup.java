package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(){
        this.flavour = "Hazelnut";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public String getFlavour(){ return flavour; }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        Syrup anotherToSyrup = (Syrup)another;
        return (flavour == anotherToSyrup.getFlavour() && unit == anotherToSyrup.getUnit()
                && amount == anotherToSyrup.getAmount());
    }

}
