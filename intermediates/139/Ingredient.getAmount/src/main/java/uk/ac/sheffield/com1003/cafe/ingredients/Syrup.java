package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour){
        this.flavour=flavour;
        this.unit= Unit.ML;
        this.amount = 10;
    }

    /**
     * Returns information about this object
     *
     * @return String listing the unit, amount and flavour of the syrup object
     */
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * Compares equality of two objects: a syrup object and another (i)
     * Checks their flavour, object type, amount and unit
     *
     * @param i syrup to compare to
     * @return true if equal, otherwise false
     */
    public boolean equals(Ingredient i){
        if( !(i instanceof Syrup)){
            return false;
        } else if(((Syrup) i).getFlavour() != this.flavour){
            return false;
        } else if (this.amount != i.getAmount()){
            return false;
        } else if (this.unit != i.getUnit()){
            return false;
        }
        else{
            return true;
        }
    }

    public String getFlavour(){
        return this.flavour;
    }
}
