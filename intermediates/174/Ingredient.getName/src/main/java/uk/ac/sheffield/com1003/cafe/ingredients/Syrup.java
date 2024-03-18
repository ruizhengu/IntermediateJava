/**
 * Syrup.java
 * Provides information about the syrup
 * @author AlAnood AlRiyami
 */
package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    /**
     * Constructor that takes the syrup flavour as "Vanilla",
     * amount of 5 in unit ml.
     */
    public Syrup(){
        this.amount=5;
        this.unit=Unit.ML;
        this.flavour="Vanilla";
    }

    /**
     * Constructor that takes the flavour of
     * syrup as parameters.
     */
    public Syrup(String flavour){
        this.flavour= flavour;
    }

    /**
     * @return Returns a string representation of the syrup in
     * the format "Syrup: [unit= <unit>, amount=<amount>, flavour=<flavour>]"
     */

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour +"]" ;
    }
}
