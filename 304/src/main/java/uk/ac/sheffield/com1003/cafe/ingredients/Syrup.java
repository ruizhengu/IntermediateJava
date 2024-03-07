package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup(String flavour) {
        this.flavour = flavour;
        this.amount = 10;
        this.unit = Unit.ML;
    }

    public Syrup(){
        this.flavour = "Strawberry";
        this.amount = 10;
        this.unit = Unit.ML;
    }

    /*
     * Overriding to check if param (syrup) is equal to object and the syrup ingredient is the same with the recipe
     * customer is asking, return false if the class is different
     * Compare if all the details such as amount, unit and flavour is the same, return true if everything is same
     */
    public boolean equals(Object syrup){
        if (syrup == this) {
            return true;
        }

        if(syrup.getClass() != this.getClass()) {
            return false;
        }

        Syrup syrupCompared = (Syrup) syrup;

        if ((syrupCompared.amount == this.amount) && (syrupCompared.unit == this.unit)
                && (syrupCompared.flavour.equals(this.flavour)) ) {
            return true;
        }

        return false;
    }
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
