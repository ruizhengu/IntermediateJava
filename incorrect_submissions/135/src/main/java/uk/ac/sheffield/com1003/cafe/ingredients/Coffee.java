package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if(!(another instanceof Coffee)){
            return false;
        }else{
            Coffee that = (Coffee) another;
            return this.getAmount() == that.getAmount() && this.decaf == that.decaf
                    && this.getUnit() == that.getUnit() && Objects.equals(this.getName(), that.getName());
        }
    }
}
