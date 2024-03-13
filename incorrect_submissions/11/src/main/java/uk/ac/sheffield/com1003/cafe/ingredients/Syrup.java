package uk.ac.sheffield.com1003.cafe.ingredients;


public class Syrup extends Ingredient{
    /**
     * public class that I made for task 6
     * adds a new option to ingredients as well
     */
    private String flavour;
    public Syrup() {
        this.amount = 30;
    }

    public Syrup(String flavour){
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }
    // override
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }


}
