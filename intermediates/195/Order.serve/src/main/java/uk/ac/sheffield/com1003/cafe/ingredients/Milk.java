package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
    }
    public Milk(Type type){
        this.type=type;
    }
    public Type getType(){
        return type;
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

    /**
     * Compares the Milk to the specified object to determine if they are equal.
     *
     * @param another
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Milk))
            return false;
        Milk otherMilk = (Milk) another;
        if (this.type != otherMilk.type)
            return false;
        if (this.amount != otherMilk.amount)
            return false;
        if (this.unit != otherMilk.unit)
            return false;
        if (this.name != otherMilk.name)
            return false;
        return true;
    }
}
