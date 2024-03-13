package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }
    public Type getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
    
    // Overriding equals method from superclass Ingredient (needed for task 5)
    @Override 
    public boolean equals(Object another){
        if(another == null || ! (another instanceof Ingredient)){
            return false;
        }
         if ( another instanceof Milk && type == ((Milk) another).getType() && 
         ((Ingredient)another).getName().equals(this.name) && ((Ingredient)another).amount == this.amount &&
          ((Ingredient)another).unit == this.unit ){
            return true;
        }
        return false;
        
    }
}
