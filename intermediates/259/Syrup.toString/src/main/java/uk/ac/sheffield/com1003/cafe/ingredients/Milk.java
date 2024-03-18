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

    //equals method for milk
    public boolean equals(Object milk) {
        if (milk == this) {
            return true;
        }

        if (! (milk.getClass() == this.getClass()) ) {
            return false;
        }

        Milk m = (Milk) milk;

        if (m.unit == this.unit && m.name == this.name
                && m.amount == this.amount && m.type == this.type ) {
            return true;
        }
        return false;

    }




    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
