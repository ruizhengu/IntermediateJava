package uk.ac.sheffield.com1003.cafe.ingredients;
/** 
 * Represents milk ingredient in a Recipe
*/
public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    
    private Type type;

    static final Type DEFAULT_TYPE = Type.WHOLE;
    static final int DEFAULT_AMOUNT = 100;
    

    public Milk() {
        this(DEFAULT_AMOUNT, DEFAULT_TYPE);
    }

    public Milk(int amount) {
        this(amount, DEFAULT_TYPE);
    }

    public Milk(Type type) {
        this(DEFAULT_AMOUNT, type);
    }


    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount > 0 ? amount : DEFAULT_AMOUNT;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
