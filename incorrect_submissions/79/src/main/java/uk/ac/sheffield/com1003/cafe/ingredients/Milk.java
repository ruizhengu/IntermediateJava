package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    //Task 1
    //Add SOY
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    //Task 5
    //Create getType() to get the type of milk (whole, semi, skimmed, soy)
    public Type getType() {
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

    //Task 5
    //Use override equals() to let this run only for Milk.java
    @Override
    public boolean equals(Object another) {
        boolean all = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (name.equals(((Ingredient)another).getName()))
            if (unit.equals(((Ingredient)another).getUnit())) 
                if (amount == ((Ingredient)another).getAmount())
                    if (type.equals(((Milk)another).getType()))
            all = true;
        return all;
    }
}
