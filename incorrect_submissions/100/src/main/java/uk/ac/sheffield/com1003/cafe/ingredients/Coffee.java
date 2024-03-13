package uk.ac.sheffield.com1003.cafe.ingredients;

import java.util.Objects;


public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit=Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount){this(amount = 8,false);}


    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    //comparing the coffee class elements that it is in the ingredients by overriding it
    @Override
    public boolean equals(Object oCoffee) {
        if (this == oCoffee)
            return true;
        if (oCoffee == null || getClass() != oCoffee.getClass())
            return false;

        Coffee coffee = (Coffee) oCoffee;
        if (coffee.amount==this.amount && coffee.name==this.name && coffee.unit == this.unit &&
                coffee.decaf==this.decaf)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
