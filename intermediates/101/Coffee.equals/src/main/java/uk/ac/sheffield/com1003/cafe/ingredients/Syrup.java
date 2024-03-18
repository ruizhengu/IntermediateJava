package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    //default constructor
    public Syrup(){
        this.amount = 8;
        this.unit = Unit.ML;
        this.flavour = "Wheat";
    }
    //constructor with flavour as argument
    public Syrup(String flavour){
        this.flavour = flavour;
        this.amount = 8;
        this.unit = Unit.ML;
    }
    //override toString method
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * update the equals methods to check name,
     * unit, Syrup and amount to be equal
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (!name.equals(((Ingredient) another).getName())){
            return false;
        }
        if (unit != ((Ingredient) another).getUnit()){
            return false;
        }
        if (amount != ((Ingredient) another).getAmount()){
            return false;
        }
        if (another instanceof Syrup){
            if (flavour !=((Syrup) another).flavour){
                return false;
            }
        }
        return true;
    }
}
