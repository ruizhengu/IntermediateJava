/**
* Milk.java
*
*
* 16/03/2023
*
* @author Mu'az bin Mohamad Nor Sazelim
*/

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type {
        WHOLE, SEMI, SKIMMED, SOY
    };

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
    public boolean equals(Object another) {
        if (another instanceof Milk) {
            Milk milk2 = (Milk) another;
            if (name.equals(milk2.getName()) && unit.equals(milk2.getUnit()) && amount == milk2.getAmount()
                    && type == milk2.type) {
                return true;
            }

            return false;
        }
        return false;
    }
}
