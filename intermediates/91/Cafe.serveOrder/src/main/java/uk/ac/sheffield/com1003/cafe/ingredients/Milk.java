package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

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


    /**
     * Compares whether two objects are equal
     * @return True if both objects are Milk objects with equal variables, false otherwise
     */
    public boolean equals(Object otherObject)
    {
        if (otherObject == null) { return false; }
        if (!(otherObject instanceof  Ingredient)) { return false; }
        if (this.getClass() != otherObject.getClass()) { return false; }
        Ingredient tempIngredient = (Ingredient) otherObject;
        if (this.getName() != tempIngredient.getName()) { return false; }

        Milk tempMilk = (Milk) otherObject;
        if (this.unit == tempMilk.unit && this.amount == tempMilk.amount && this.type == tempMilk.type)
        { return true; }
        else { return false; }
    }
}
