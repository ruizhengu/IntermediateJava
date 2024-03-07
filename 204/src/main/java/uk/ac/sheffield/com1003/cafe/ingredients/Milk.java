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

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
    
    public boolean equals(Object objectTwo) {
        if ( objectTwo == this)
            return true;
        if ( objectTwo == null || this.getClass() != objectTwo.getClass() ) 
            return false;
        // convert object to milk type and compare instance variables
        Milk milkTwo = (Milk)objectTwo;
        if (name.equals(milkTwo.name) && unit == milkTwo.unit && amount == milkTwo.amount && 
                type == milkTwo.type)
            return true;
        return false;
    }
}
