package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;

public class Milk extends Ingredient {
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

    public Type getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object another) {
        if(!(another instanceof Milk)){
            return false;
        }else{
            Milk that = (Milk)another;
//            if(this.getAmount() == that.getAmount()){
//                System.out.println("Milk - amount match");
//            }
//            if(this.getType() == that.getType()){
//                System.out.println("Milk - type match");
//            }
            return this.getAmount() == that.getAmount() && this.type == that.type
                    && this.getUnit() == that.getUnit() && Objects.equals(this.getName(), that.getName());
        }
    }
}
