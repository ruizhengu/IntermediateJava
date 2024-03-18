package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {     //Defining the Syrup class
    private String flavour;     //One unique instance variable "flavour"

    public Syrup () {
        this.name = "Syrup";        //Default constructor for when there are no attributes passed to the Syrup constructor
        this.unit = Unit.ML;
        this.amount = 50;
        this.flavour = "Sweet";
    }
    
    public Syrup (String flavour) {
        this.name = "Syrup";        //Overloaded the Syrup constructor so flavour can be changed
        this.unit = Unit.ML;
        this.amount = 50;
        this.flavour = flavour;
    }

    public String toString () { //Method to print a syrup object as a string
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    
    public boolean equals(Syrup another) {
        boolean check = true;       //Overriding the equals method in ingredient.java to check if the flavour instance variable is the same in two syrup objects
        if (flavour != another.flavour) {
            check = false;
        }
        return check;
    }
}
