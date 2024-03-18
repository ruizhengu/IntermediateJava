package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup() {
        this.name = "Syrup";
        this.amount = 20;
        this.unit = Unit.ML;
        this.flavour = "Caramel";
    }
    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 20;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }
    public String toString() { //Override
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour +"]";
    }

    //Override .equals
    public boolean equals(Object myObj) {
        if (!(myObj instanceof Syrup)) {
            return false; //Not a Syrup
        }
        Syrup otherSyrup = (Syrup) myObj;
        if (name.equals(otherSyrup.name) && amount==otherSyrup.amount && unit==otherSyrup.unit && flavour.equals(otherSyrup.flavour)) {
            return true;
        } else {
            return false;
        }
    }

}
