package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup(){
        this.name = "Flavour";
        this.unit = Unit.ML;
        this.flavour = "Chocolate";
    }

    public Syrup(String flavour) {
        this.name = "Flavour";
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 5;
    }

    public String getFlavour(){
        return flavour;
    }

    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /** 
     * Override the equals to syrup
     * @param another is the compared syrup
     * @return true if two syrups are totally same
    */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;

        if (name.equals(((Syrup)another).getName()) &&
            amount == ((Syrup)another).getAmount() &&
                unit.equals(((Syrup)another).getUnit()) &&
                    flavour == ((Syrup)another).flavour ) {       
            return true;   
        }else{
            return false;
        }
    }
}
