package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount){
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another){
        if(another==null||!(another instanceof Water)){
            return false;
        }else{
            if(amount==((Water)another).getAmount()){
                return true;
            }else{
                return false;
            }
        }
    }
}
