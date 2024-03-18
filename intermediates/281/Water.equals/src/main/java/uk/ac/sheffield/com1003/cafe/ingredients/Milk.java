package uk.ac.sheffield.com1003.cafe.ingredients;

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
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object object) {
        // Checks if the both objects are identical
        if (this == object) return true;

        // Checks if the object is null
        if (object == null) return false;

        // Ensures the objects are of the same class
        if (!(object instanceof Milk)) return false;
        Milk milk = (Milk) object;
        // Checks if all the properties of the class are equal or not
        return (this.name.equals(milk.name)
                && this.amount == milk.amount
                && this.unit.equals(milk.unit)
                && this.type == milk.type);
    }
}
