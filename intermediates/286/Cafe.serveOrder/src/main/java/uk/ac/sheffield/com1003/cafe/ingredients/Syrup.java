package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    /**
     * Constructor that takes as parameters flavour
     * and setting the name of the object to "Syrup",
     * unit to ML, and the amount to 15.
     * 
     * @param flavour Desired flavour of the syrup
     */
    public Syrup(String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 15;
        this.flavour = flavour;
    }

    public Syrup(){
        this("Strawberry");
    }

    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
