package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
   private String flavour;
//creating a syrup class to be able to add syrups
   public Syrup(String flavour){
       this.unit = Unit.ML;
       this.amount = 20;
       this.flavour = flavour;
   }



    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
