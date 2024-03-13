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

    public Milk(Type type) {
        this.type = type;
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

    @Override
    public boolean equals(Object milk) {
        if (milk == this) {
            return true;
        }
 
        if (!(milk instanceof Milk)) {
            return false;
        }

        Milk nMilk = (Milk) milk;
        if (this.name.equals(nMilk.name) && 
        this.unit == nMilk.unit &&
        this.amount == nMilk.amount &&
        this.type == nMilk.type) {
            return true;
        } else {
            return false;
        }
    }
}
