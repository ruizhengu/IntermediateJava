package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public Water(int amount){
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if(!(another instanceof Water)){
            return false;
        }else{
            Water that = (Water) another;
            return this.getAmount() == that.getAmount()
                    && this.getUnit() == that.getUnit() && Objects.equals(this.getName(), that.getName());
        }
    }
}
