package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour ;

    public Syrup(){
        this.flavour = "chocolate";
        this.unit = Unit.ML;
        this.amount = 10 ;
    }

    public Syrup(String flavour){
        this.flavour= flavour ;
    }

    public Syrup(String flavour,Unit unit){
        this.flavour= flavour ;
        this.unit=unit;
    }

    public Syrup(String flavour,Unit unit,int amount){
        this.flavour= flavour ;
        this.unit=unit;
        this.amount=amount ;
    }


    @Override
    public String toString() {
        return "Syrup [unit=" + unit +", amount="+ amount + ", flavour=" + flavour + "]";
    }
}
