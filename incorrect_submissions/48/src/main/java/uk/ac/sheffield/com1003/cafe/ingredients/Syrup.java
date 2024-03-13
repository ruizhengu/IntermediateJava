package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    //Default constructor with values set as 20ml and chocolate flavoured syrup
    public Syrup(){
        this(20, "chocolate");
    }
    //Overloaded with custom amount in ml
    public Syrup(int amount){
        this(amount, "chocolate");
    }
    //Overloaded with custom amount and flavour
    public Syrup(int amount, String flavour){
        this.flavour = flavour;
        super.amount = amount;
        super.unit = Unit.ML;
    }

    @Override
    public boolean equals(Object other){
        if (other == null || ! (other instanceof Syrup))
            return false;
        return name.equals(((Syrup)other).getName())
            && super.unit == ((Syrup)other).getUnit()
            && super.amount == ((Syrup)other).getAmount()
            && this.flavour.equals(((Syrup)other).flavour);
    }

    @Override
    public String toString(){
        return "Syrup [unit=" + this.unit + ", amount=" + this.amount + ", flavour=" + this.flavour + "]";
    }
    
}
