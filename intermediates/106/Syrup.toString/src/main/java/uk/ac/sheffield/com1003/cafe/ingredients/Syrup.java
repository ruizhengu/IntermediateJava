package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this("Chocolate");
    }

    public Syrup(String flavour) {
        this(flavour, 30);
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + "flavour=" + flavour + "]";
    }


    /**
     * Two syrups are equal if they have the same name, amount, unit and flavour
     * 
     * @param another the Syrup object to compare to
     * @return true if the two syrups are equal, false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup)){
            return false;
        }

        Syrup anotherSyrup = (Syrup)another;
        if (anotherSyrup.getName().equals(this.name) && anotherSyrup.getAmount() == this.amount 
        && anotherSyrup.getUnit() == this.unit && anotherSyrup.getFlavour() == this.flavour){
            return true;
        } else {
            return false;
        }
    }
}
