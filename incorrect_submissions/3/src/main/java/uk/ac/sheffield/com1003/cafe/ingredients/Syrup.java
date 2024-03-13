package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;
    
    public Syrup(){
        this.flavour = "Vanilla";
        this.unit = Unit.ML;
        this.amount = 10;
    }
    public Syrup(String flavour){
        this.flavour = flavour;
    }
    public Syrup(String flavour,int amount){
        this.flavour = flavour;
        this.amount =  amount;

    }
    public String getFlavour(){
        return flavour;
    }

    @Override
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour="  + flavour + "]";      
    }


    /**
     * compares 2 objects and returns wether they are equal in their values 
     * 
     * @param ingredentTwo ingredient to compare against the first
     * @return boolean whether they are equal or not
     */
    @Override
    public boolean equals(Object ingredientTwo){
        if (ingredientTwo == null || ! (ingredientTwo instanceof Syrup))
            return false;
        Syrup syrupTwo = (Syrup)ingredientTwo;
        return name.equals(syrupTwo.getName()) && amount == syrupTwo.amount && unit.equals(syrupTwo.getUnit()) && flavour.equals(syrupTwo.flavour);
    }
}   