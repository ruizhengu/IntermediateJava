package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

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

    public boolean equals(Milk milk) {
        //checks to see if all values are the same and if so returns true
        if (this.name == milk.getName() && this.unit == milk.getUnit()
            && this.amount == this.getAmount() && this.type == milk.getType()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
