package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;

public class Milk extends Ingredient {
    public enum Type {WHOLE, SEMI, SKIMMED, SOY}

    ;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milk milk = (Milk) o;
        return name.equals(milk.name) && type.equals(milk.type) && amount == milk.getAmount() && unit == milk.getUnit();
    }







    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
