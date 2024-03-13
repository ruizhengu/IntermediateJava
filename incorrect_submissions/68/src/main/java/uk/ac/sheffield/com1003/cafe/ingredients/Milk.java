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
     * Checks whether a passed in object is an ingredient of the same
     * type, and has the same instance variable values
     * @param other The object being compared with
     * @return Returns true if the passed in ingredient matches this instance
     */
    @Override
    public boolean equals(Object other){

        if (!(other instanceof Milk)){
            return false;
        }

        Milk otherMilk = ((Milk)other);

        if(!name.equals(otherMilk.getName())){
            return false;
        }
        if(!unit.equals(otherMilk.getUnit())){
            return false;
        }

        if(amount != otherMilk.getAmount()){
            return false;
        }

        if(!type.equals(otherMilk.type)){
            return false;
        }

        return true;
    }
}
