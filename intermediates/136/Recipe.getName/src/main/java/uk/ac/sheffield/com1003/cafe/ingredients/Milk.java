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

    public Milk(Type type) {
    	this(100,type);
    }
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Milk)) {
            return false;
        }
        Milk other = (Milk) obj;
        if (!this.getName().equals(other.getName())) {
            return false;
        }
        if (!(this.type == other.type)) {
            return false;
        }
        if (!(this.unit == other.unit)) {
            return false;
        }
        if (Double.doubleToLongBits(this.getAmount()) != Double.doubleToLongBits(other.getAmount())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
