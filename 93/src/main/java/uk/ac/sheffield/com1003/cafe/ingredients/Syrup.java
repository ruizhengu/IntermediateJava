package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup(){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 20;
        this.flavour = "Maple";
    }

    public Syrup(String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 20;
        this.flavour = flavour;
    }

    @Override
    public String toString() { return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]"; }

    /**
     * Find recipe with same instance and compare it to the object method is called from
     * @param another object being compared
     * @return Returns true if it is the same class and all variables are the same; false otherwise
     */
    @Override
    public boolean equals(Object another) {
        //check if class is the same
        if (super.equals(another)) {
            Syrup other = (Syrup) another;
            //compare variables
            if (this.getName() == other.getName()
                    && this.amount == other.amount
                    && this.unit == other.unit
                    && this.flavour == other.flavour ){

                return true;
            }
        }
        return false;
    }
}
