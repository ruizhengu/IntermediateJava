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

    
    //Compares two Milk objects to see if they have the same name, unit, amount, and type .
    @Override
    public boolean equals(Object another) {
        if (another instanceof Milk) {
            Milk otherMilk = (Milk) another;
            if (name.equals(otherMilk.getName()) && unit.equals((otherMilk.getUnit())) && amount == otherMilk.getAmount()
                    && type == otherMilk.type) {
                return true;
            }
            return false;
        }
        return false;
    }

}
