package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {

    public enum Type { WHOLE, SEMI, SKIMMED, SOY;};
    private Type type = Type.WHOLE;

    /**
     * Constructor that initialises the default amount to 100 and type of milk to whole
     */
    public Milk() {
        this(100, Type.WHOLE);
    }

    /**
     * Constructor that takes in amount of milk as a parameter
     * @param amount The amount of milk
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    /**
     * Constructor that takes in amount and type of milk as a parameter
     * Initialises name, amount, type and sets default unit of milk as ML
     * @param amount The amount of milk
     * @param type The type of milk
     */
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
     * equals() method to compare two milk objects
     * Checks if the two objects are the same class, have the same type, amount, and unit
     * @param o The object passed into the parameter of the method, to be compared
     * @return True is returned if class, type, amount and unit are the same, or false is returned otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;}

        Milk m = (Milk) o;

        if (!(type.equals(m.type)) || !(Integer.compare(amount,m.amount) == 0) || !(this.unit == m.unit)) {
            System.out.println("Milk is not the same");
        }

        return type.equals(m.type) && Integer.compare(amount,m.amount) == 0 && this.unit == m.unit;

    }
}
