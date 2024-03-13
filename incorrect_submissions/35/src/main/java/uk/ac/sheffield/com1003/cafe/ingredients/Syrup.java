package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() { // default constructor with no param, uses predefined default syrup flavour and
                     // amount
        this("classic", 8);
    }

    public Syrup(String flavour) { // constructor that takes flavour as param, able to change the flavour of the
                                   // syrup
        this(flavour, 8);
    }

    public Syrup(int amount) { // constructor taking amount as param, allow to specify amount on the default
                               // flavour
        this("classic", amount);
    }

    public Syrup(String flavour, int amount) { // constructor can specify which flavour and amount of syrup
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }
    
    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        if (another == null) {
            return false;
        }

        if (another instanceof Syrup) {
            Syrup otherSyrup = (Syrup) another;
            if (name == otherSyrup.getName()
                    && amount == otherSyrup.getAmount()
                    && unit == otherSyrup.getUnit()
                    && flavour == otherSyrup.flavour) {
                return true;

            }
        }
        return false;
    }

    public String toString() {
        return "Syrup [unit= " + unit + ", amount= " + amount + ", flavour= " + flavour + "]";
    }

}
