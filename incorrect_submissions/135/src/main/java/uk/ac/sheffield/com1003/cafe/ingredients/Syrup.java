package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;

public class Syrup extends Ingredient{
    public String flavour;

    public Syrup() {
        this.amount = 8;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "Maple";
    }


    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour(){
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit={" + unit + "}, amount={" + amount + "}, flavour={" + flavour + "}]";
    }

    @Override
    public boolean equals(Object another) {
        if(!(another instanceof Syrup)){
            return false;
        }else{
            Syrup that = (Syrup) another;
            return this.getAmount() == that.getAmount() && this.flavour == that.flavour
                    && this.getUnit() == that.getUnit() && Objects.equals(this.getName(), that.getName());
        }
    }
}
