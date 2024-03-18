package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup(){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "apple";
        this.amount = 10;
    }

    public Syrup(int amount){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "apple";
        this.amount = amount;
    }

    public Syrup(String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = flavour;
        this.amount = 10;
    }

    public Syrup(int amount, String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another){
        if(another==null||!(another instanceof Syrup)){
            return false;
        }else{
            if(amount==((Syrup)another).getAmount()&&flavour.equals(((Syrup)another).flavour)){
                return true;
            }else{
                return false;
            }
        }
    }
}
