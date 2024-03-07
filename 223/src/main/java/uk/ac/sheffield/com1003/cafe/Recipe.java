package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
        
    }

    public Recipe(String name, double price, Size size, int numberOfIngredients) {
        this.name = name;
        this.price = price;
        this.size = size;
        ingredients = new Ingredient[numberOfIngredients];
    }

    /**
     * Add ingredient to recipe if it does not already exist.
     * If ingredient with the same name already exists, replace it with the new one.
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the recipe would be exceeded
     */
    public void addIngredient(Ingredient ingredient) throws TooManyIngredientsException {
        int i = 0;
        while (i < this.ingredients.length) {
            if (this.ingredients[i] == null || this.ingredients[i].equals(ingredient)) {
                this.ingredients[i] = ingredient;
                return;
            } else
                i++;
        }
        throw new TooManyIngredientsException("Too many ingredients");//isnt being caught for some reason
        
            
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Checks whether recipe is ready to be used.
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    public boolean equals(Recipe recipe1){
        String [] equalIng = new String [ingredients.length];//documents whether the ingredients are all equal
        boolean equalItem = false;
        if(recipe1.getPrice() == this.getPrice() && recipe1.size == this.size && recipe1.ingredients.length == this.ingredients.length){//checks basic values of price, size and recipe length
            for (int i = 0; i <= recipe1.ingredients.length-1;i++){
                for (int j=0;j<=this.ingredients.length-1; j++){
                    if (recipe1.ingredients[i]==this.ingredients[j]){//sees if ingredients are the same
                        if (recipe1.ingredients[i].getAmount()==this.ingredients[j].getAmount()){//checks the amounts if the ingredients are the same
                            equalItem = true;
                            break;//breaks the for loops so i isnt checked again
                        }
                    }else{
                        equalIng[i]="not";
                        equalItem =false;
                    }
                }
                if(equalItem ==true){
                    equalIng[i] = "equal";//overwrites any "not" values when values are equal
                }
            }

            for(int i=0;i<=equalIng.length-1;i++){//checks for a full array of "equal" values
                if(equalIng[i]!="equal"){
                    System.out.println("Recipes are not equal");//if a "not" is found return false
                    return false;
                }
            }
            System.out.println("Recipes are equal");//else return true
            return true;
        }
        System.out.println("Recipes are not equal");
        return false;
        
    }   
}
