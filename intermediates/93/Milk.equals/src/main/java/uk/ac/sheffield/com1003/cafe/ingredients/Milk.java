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

    /**
     * Find recipe with same instance and compare it to the object method is called from
     * @param another object being compared
     * @return Returns true if it is the same class and all variables are the same; false otherwise
     */
    @Override
    public boolean equals(Object another) {
        //check if class is the same
        if (super.equals(another)) {
            Milk other = (Milk) another;
            //compare variables
            if (this.getName() == other.getName()
                    && this.amount == other.amount
                    && this.unit == other.unit
                    && this.type == other.type ){

                return true;
            }
        }
        return false;
    }
}
