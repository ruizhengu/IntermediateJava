package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class Syrup extends Ingredient{

        private String name;
        private double price;
        private String flavor;
        private Ingredient[] ingredients;


    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavor=" + flavor + "]";
    }
}


