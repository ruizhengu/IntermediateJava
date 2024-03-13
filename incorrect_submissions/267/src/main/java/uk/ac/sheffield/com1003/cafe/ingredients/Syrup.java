package uk.ac.sheffield.com1003.cafe.ingredients;

/**

 A class that represents a syrup ingredient with a name, amount, and flavour.
 Syrups can be used to add flavor to coffee drinks, and can be measured in milliliters or ounces.
 */



public class Syrup extends Ingredient{
    private String flavour;
    public Syrup(String name, int amount, String flavour){
        this.name = name;
        this.amount = amount;
        this.flavour = flavour;
    }
    public Syrup(String flavour) {
        this.flavour = flavour;
    }
    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}
