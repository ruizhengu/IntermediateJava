package uk.ac.sheffield.com1003.cafe.ingredients;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

//created a class for Syrup
public class Syrup extends Ingredient{

    //This code defines a constructor method for a class called Syrup that sets initial values for the amount, unit,
    // and flavour properties of an instance of the class.
    private String flavour;
    public Syrup(String flavour){
        this.amount = 10;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }


//This code overrides the toString() method of class Syrup and returns a string representation of the
// properties of the instance of the class.
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
