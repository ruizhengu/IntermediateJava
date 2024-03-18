package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
//Task 6, creating a class for syrup class
    private String flavour;

    private Syrup(String flavour) {
        this.flavour = flavour;
    }

    public Syrup(int amount, String flavour) {
        //setting the amount, unit and flavour
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;

    }





        @Override
        public String toString() {
            return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
        }
    }




