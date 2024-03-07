package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water(){
        this(30);
    }
    
    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
    /*Overriding equals method to check if two Water objects are the same */
    @Override
    public boolean equals(Object another){
        if (another instanceof Water 
        && (amount == ((Water)another).getAmount())
        && unit.equals(((Water)another).getUnit())){
            return true;
        }
        else    
            return false;
    }
}
