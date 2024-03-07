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

    @Override
    public boolean equals(Object obj) {
        //Check that object is the same class
        if(obj == null || !(obj instanceof Milk)){
            return false;
        }

        //Get object as recipe class
        Milk other = (Milk) obj;

        //Check name is the same
        if(this.name != other.name){
            return false;
        }

        //Check units the same
        if(this.unit != other.unit){
            return false;
        }

        //Check amount the same
        if(this.amount != other.amount){
            return false;
        }

        //Check Types are same
        if(this.type != other.type){
            return false;
        }

        return true;
    }
}
