package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
        super.name = "Water";
    }
    
    //Constructor that takes the amount of water as a parameter.
    public Water(int amount){
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public boolean equals(Object other){
        if (other == null || ! (other instanceof Water))
            return false;
        return name.equals(((Water)other).getName())
            && super.unit == ((Water)other).getUnit()
            && super.amount == ((Water)other).getAmount();
    }
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
