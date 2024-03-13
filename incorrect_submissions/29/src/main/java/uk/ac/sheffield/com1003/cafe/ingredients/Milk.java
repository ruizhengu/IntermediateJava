package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, /*Task 1*/ SOY };
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

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        
        Ingredient ingredient = (Ingredient) another;

        if (this.getName() == ingredient.getName() &&
        this.getAmount() == ingredient.getAmount() &&
        this.getUnit() == ingredient.getUnit()) {
            return true;
        }
        else {
            return false;
        }
    }
}
