package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    // Type is enum, SOY was added from base code
    // Levels of constructors exist to allow changed to amount and type
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = 100; 
        this.type = Type.WHOLE;
    }

    public Milk(int amount) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = Type.WHOLE;
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
}
