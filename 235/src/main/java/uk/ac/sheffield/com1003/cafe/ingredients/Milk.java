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

    public Type getType() { return this.type; }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Milk)) {
            return false;
        }
        if (!name.equals(((Milk)another).getName())) {
            return false;
        }
        //checks amount, unit and type of milk is the same, false if not.
        if (amount != ((Milk)another).getAmount() || unit != ((Milk)another).getUnit() || type != ((Milk)another).getType()) {
            return false;
        }

        return true;
    }
}
