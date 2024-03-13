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

    /**
     * Getter for milk type
     * @return Milk type
     */
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    public boolean equals(Object o) {

        /* If statement below will try to Cast parameter into Milk
        * Otherwise, will return false
        */
        if (o == null || ! (o instanceof Milk))
            return false;
        Milk milk = (Milk)o;

        /*Sequence below stores equivalence of Class attributes
        * Then returns false if any are not equal
        */
        boolean sameName = (this.name == milk.name);
        boolean sameAmount = (this.amount == milk.amount);
        boolean sameUnit = (this.unit == milk.unit);
        boolean sameType = (this.type == milk.type);

        if (!sameName || !sameAmount || !sameUnit || !sameType) {
            return false;
        }
        
        return true;
    }
}
