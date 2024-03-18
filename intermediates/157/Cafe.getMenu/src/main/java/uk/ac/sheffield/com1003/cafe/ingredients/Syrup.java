package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.amount = 50;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "Caramel";
    }

    public Syrup(String flavour) {
        this.amount = 50;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override 
    public String toString() {
        return "Syrup [unit=" + unit + ", amount="+ amount + ", flavour="+ flavour + "]";
    }

    /**
     * Method for checking whether two Syrup objects are equal
     * 
     * @param another
     * @return True if both Syrup objects have the same instance variables
     */
    @Override
    public boolean equals(Object another) {
        if (another!=null && another instanceof Syrup) {
            Syrup comparison = (Syrup)another;
            if (this.name==comparison.name) {
                if (this.amount==comparison.amount) {
                    if (this.unit==comparison.unit) {
                        if (this.flavour==comparison.flavour) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
}
