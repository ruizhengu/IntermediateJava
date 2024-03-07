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
        return type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    /*Overriding equals method to check if two Milk objects are the same */
    @Override
    public boolean equals(Object another){
        if (another instanceof Milk 
        && (amount == ((Milk)another).getAmount())
        && unit.equals(((Milk)another).getUnit())
        && type.equals(((Milk)another).getType())){
            return true;
        }
        else    
            return false;
    }
}
