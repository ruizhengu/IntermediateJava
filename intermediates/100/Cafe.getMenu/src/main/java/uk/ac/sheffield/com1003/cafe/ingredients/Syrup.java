package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;
//creating syrup similar to others to have the same ingredients as well as the extra "flavour" ingredient.
public class Syrup extends Ingredient{

    private String flavour;

    public Syrup(){
        this.name = "Syrup";
        this.amount = 15;
        this.unit = Unit.ML;
        this.flavour = "Banana";
    }

    public Syrup (String flavour){
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }
    //comparing the syrup class elements that it is in the ingredients by overriding it
    public boolean equals(Object oSyrup) {
        if (this == oSyrup)
            return true;
        if (oSyrup == null || getClass() != oSyrup.getClass())
            return false;

        Syrup syrup = (Syrup) oSyrup;
        if (syrup.amount==this.amount && syrup.name==this.name && syrup.unit == this.unit &&
                syrup.flavour==syrup.flavour)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
