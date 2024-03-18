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

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() { return type; }

    @Override
    public String getName() { return this.name; }

    @Override
    public Unit getUnit() { return this.unit; }

    @Override
    public int getAmount() { return this.amount; }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Milk))
            return false;
        return name.equals(((Milk)another).getName()) &&
                unit.equals(((Milk)another).getUnit()) &&
                amount == ((Milk) another).getAmount() &&
                type.equals(((Milk)another).getType());
    }

}

