package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100);
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }
    /**
     * 
     * @param amount
     * @param type
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
     * compares 2 objects and returns wether they are equal in their values 
     * 
     * @param ingredentTwo ingredient to compare against the first
     * @return boolean whether they are equal or not
     */
    @Override
    public boolean equals(Object ingredientTwo){
        if (ingredientTwo == null || ! (ingredientTwo instanceof Milk))
            return false;
        Milk milkTwo = (Milk)ingredientTwo;
        return name.equals(milkTwo.getName()) && amount == milkTwo.amount && unit.equals(milkTwo.getUnit()) && type.equals(milkTwo.type);
    }

}
