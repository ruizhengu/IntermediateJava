package uk.ac.sheffield.com1003.cafe.ingredients;

    /**
     * Creates a new Syrup object with default values.
     */

public class Syrup extends Ingredient {

    private String flavour;

    /**
     * Returns a String representation of the Syrup object.
     * @return A String representation of the Syrup object.
     */
    public Syrup(){
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = "Caramel";
        this.name = "Syrup";
    }

    /**
     * Creates a new Syrup object with the specified flavour.
     * @param flavour The flavour of the Syrup.
     */

    public Syrup(String flavour){
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = flavour;
        this.name = "Syrup";
    }

    
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour="+ flavour + "]";
    }


        /**

    Overrides the equals() method to compare Syrup objects based on their amount, unit, and flavor.
    @param obj The object to compare to this Syrup object.
    @return true if the objects are equal based on their amount, unit, and flavour, false otherwise.
    */

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Syrup)){
            return false;
        }
        Syrup other = (Syrup) obj;
        return this.getAmount() == other.getAmount() &&
                this.getUnit().equals(other.getUnit()) &&
                this.flavour.equals(other.flavour);
    } 
}

