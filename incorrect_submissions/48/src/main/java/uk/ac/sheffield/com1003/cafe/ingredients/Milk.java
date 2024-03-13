package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY};//Added SOY as a milk type
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
    }

    //Constructor that takes amount of Milk as a parameter
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
    public boolean equals(Object other){
        if (other == null || ! (other instanceof Milk))
            return false;
        return name.equals(((Milk)other).getName())
            && super.unit == ((Milk)other).getUnit()
            && super.amount == ((Milk)other).getAmount()
            && this.type == ((Milk)other).type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
