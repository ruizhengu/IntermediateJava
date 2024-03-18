package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY }
    private Type type = Type.WHOLE;

    public Milk() {
        this(100);
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

    //Get methods for Milk
    public Type getType() {
        return type;
    }

    /**
     * Checks whether two milk objects are the same.
     * If both milk objects have the same instance variables, they are the same milk object.
     *
     * @param another
     * @return True if all the above criteria is met and false otherwise
     */
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        else if (name.equals(((Ingredient)another).getName())) {
            Milk anotherMilk = (Milk) another;
            return this.getUnit() == anotherMilk.getUnit() && this.getAmount() == anotherMilk.getAmount()
                    && this.getType() == anotherMilk.getType();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
