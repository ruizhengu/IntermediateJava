package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    //defualt constructor
    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 30;
        this.flavour = "Fuity";
    }

    //constructor for just flavour
    public Syrup(String flavour) {
        this.flavour = flavour;
    }

    //constructor for 2 arguments
    public Syrup(String flavour,int amount) {
        this.flavour = flavour;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}

