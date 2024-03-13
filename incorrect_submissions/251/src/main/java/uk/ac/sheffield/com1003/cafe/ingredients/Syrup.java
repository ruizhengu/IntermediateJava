package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavor;

    public Syrup(){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavor = "apple";
        this.amount = 10;
    }

    public Syrup(int amount){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavor = "apple";
        this.amount = amount;
    }

    public Syrup(String flavor){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavor = flavor;
        this.amount = 10;
    }

    public Syrup(int amount, String flavor){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavor = flavor;
    }

    @Override
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavor=" + flavor + "]";
    }

    @Override
    public boolean equals(Object another){
        if(another==null||!(another instanceof Syrup)){
            return false;
        }else{
            if(amount==((Syrup)another).getAmount()&&flavor.equals(((Syrup)another).flavor)){
                return true;
            }else{
                return false;
            }
        }
    }
}
