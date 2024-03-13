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

    public boolean equals(Object ingredient){
        if (ingredient == null || ! (ingredient instanceof Milk)) {
            return false;
        } else {
            if (((Milk) ingredient).type == type &&
                    ((Milk) ingredient).name == name &&
                    ((Milk) ingredient).amount == amount &&
                    ((Milk) ingredient).unit == unit) {
                return true;
            } else {
                return false;
            }
        }
    }
}
