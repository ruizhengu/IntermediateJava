package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;



public class App {
    public void main(String []args){
        //create cafe instance and add recipes
        Cafe cafe = new Cafe();
        try{
            Recipe espresso = cafe.createEspresso();
            cafe.addRecipe(espresso);
            Recipe double_espresso = cafe.createDoubleEspresso();
            cafe.addRecipe(double_espresso);
            Recipe large_soy_latte = cafe.createLargeSoyLatte();
            cafe.addRecipe(large_soy_latte);
        }
        //output message if excpetion thrown
        catch(TooManyIngredientsException recipe){
            System.out.println(recipe+ " cannot add recipe as there are too many ingredients");
        }
        cafe.printMenu();
    }

}
