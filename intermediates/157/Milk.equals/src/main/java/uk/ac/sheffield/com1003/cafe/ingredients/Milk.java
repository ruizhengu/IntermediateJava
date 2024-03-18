package uk.ac.sheffield.com1003.cafe.ingredients;

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
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    /**
     * Method for checking whether two Milk objects are equal
     * 
     * @param another
     * @return True if both Milk objects have the same instance variables
     */
    @Override
    public boolean equals(Object another) {
        if (another!=null && (another instanceof Milk)) {
            Milk comparison = (Milk)another;
            if (this.name==comparison.name) {
                if (this.amount==comparison.amount) {
                    if (this.unit==comparison.unit) {
                        if (this.type==comparison.type) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
