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

    public Type getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object another) {
        boolean same = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        //comparing name, amount, Unit and type of another Ingredient object
        if (name.equals(((Ingredient)another).getName()) && amount == ((Ingredient)another).getAmount() && unit.equals(((Ingredient)another).getUnit()) && type == (((Milk)another).getType()))
            same = true;
        return same;
    }
}
