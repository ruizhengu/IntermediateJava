package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
        this.name = "Milk";
        this.unit = Unit.ML;
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
        this.name = "Milk";
        this.unit = Unit.ML;
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
    Overrides the equals() method to compare Milk objects based on their amount, unit, and type.
    @param obj The object to compare to this Milk object.
    @return true if the objects are equal based on their amount, unit, and type, false otherwise.
    */
    
    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Milk)){
            return false;
        }
        Milk other = (Milk) obj;
        return this.getAmount() == other.getAmount() &&
                this.getUnit().equals(other.getUnit()) &&
                this.type.equals(other.type);
        } 
    }


