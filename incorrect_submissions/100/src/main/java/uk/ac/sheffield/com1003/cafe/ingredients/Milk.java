package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY};
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
    //comparing the milk class elements that it is in the ingredients by overriding it
    public boolean equals(Object oMilk) {
        if (this == oMilk)
            return true;
        if (oMilk == null || getClass() != oMilk.getClass())
            return false;

        Milk milk = (Milk) oMilk;
        if (milk.amount==this.amount && milk.name==this.name && milk.unit == this.unit &&
                milk.type==this.type)
        return true;

        return false;
    }



    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
