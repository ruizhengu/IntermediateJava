package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY}; //added soy
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

    /*
     * Overriding to check if param (milk) is equal to object and the milk ingredient is the same with the
     * recipe customer is asking, return false if the class is different
     * Compare if all the details such as amount, unit, name  and type are the same, return true if everything is same
     */
    public boolean equals(Object milk){
        //if param (milk) is equal to object
        if (milk == this)  {
            return true;
        }

        //if param(milk)'s class is same as object class
        if (milk.getClass() != this.getClass()) {
            return false;
        }

        // Change milk instance to the Milk class
        Milk milkCompared = (Milk) milk;

        if ((milkCompared.amount == this.amount) && (milkCompared.unit == this.unit) &&
                    (milkCompared.type == this.type) && (milkCompared.name.equals(this.name))){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
