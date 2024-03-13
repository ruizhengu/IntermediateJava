package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Type getType(){
        return type; 
    }

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

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
//task5
    public boolean equals(Object other ){
        boolean alike = false;
        if (other==null || ! (other instanceof Ingredient))
        return false;
        if (name.equals(((Ingredient)other).getName()) && amount ==((Ingredient)other).getAmount() &&
         unit.equals(((Ingredient)other).getUnit()) && type == (((Milk)other).getType()))
            alike = true;
        return alike;
    }

}
