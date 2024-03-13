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

    public Milk.Type getType(){return type;}

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object o){
        if (o == null || ! (o instanceof Milk))
            return false;
        if (! this.name.equals(((Milk)o).getName())){
            return false;
        }
        if (! this.unit.equals(((Milk)o).getUnit())){
            return false;
        }
        if (! this.type.equals(((Milk)o).getType())){
            return false;
        }
        if (this.amount != ((Milk)o).getAmount()){
            return false;
        }

        return true;
    }
}
