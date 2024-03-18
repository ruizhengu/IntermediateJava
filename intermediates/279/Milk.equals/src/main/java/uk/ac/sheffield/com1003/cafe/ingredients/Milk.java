package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
        this.name = "Milk";
        this.unit = Unit.ML;
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
        this.name = "Milk";
        this.unit = Unit.ML;
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
        if (milk instanceof Milk) {
            Milk anotherMilk = (Milk) milk;
            if (this.name == anotherMilk.name && this.amount == anotherMilk.amount && this.unit == anotherMilk.unit
            && this.type == anotherMilk.type)
                return true;
            else return false;
        }else return false;
    }
}
