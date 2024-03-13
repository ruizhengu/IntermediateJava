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
     *Equality between a milk object (calling the method) and some other ingredient i
     * Checks if both objects are Milk, have the same type, amount and unit
     * @param i - Ingredient to compare to
     * @return true if both are milk Ingredients with the same amount and false otherwise
     */


    public boolean equals(Ingredient i){
        if(!(i instanceof Milk)){
            return false;
        }
        boolean equality = true;
        if (this.type != ((Milk) i).type) {
            equality = false;
        }else if (this.amount != i.getAmount()){
            return false;
        } else if (this.unit != i.getUnit()){
            return false;
        }
        return equality;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
