package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    //add SOY to Type
    public enum Type { WHOLE, SEMI, SKIMMED,SOY };
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
     * update the equals methods to check name,
     * unit, Milk and amount to be equal
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (!name.equals(((Ingredient) another).getName())){
            return false;
        }
        if (unit != ((Ingredient) another).getUnit()){
            return false;
        }
        if (amount != ((Ingredient) another).getAmount()){
            return false;
        }
        if (another instanceof Milk){
            if (type != ((Milk) another).type){
                return false;
            }
        }
        return true;
    }
}
