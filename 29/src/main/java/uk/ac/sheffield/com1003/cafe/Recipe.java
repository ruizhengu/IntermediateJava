package uk.ac.sheffield.com1003.cafe;

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
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                return;
            } else
                i++;
        }
        if (i < ingredients.length)
            ingredients[i] = ingredient;
        else
            throw new TooManyIngredientsException();
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


    /**
     * Checks if recipes are the same (By comparing: price, size, and ingredients)
     * @param recipe
     * @return True if recipes are the same, otherwise false
     */
    public boolean equals(Object otherObject) {

        if (otherObject == null || !(otherObject instanceof Recipe)) {
            return false;
        }

        Recipe recipe = (Recipe) otherObject;
        
        if (this.price != recipe.price) {
            return false;
        }

        if (this.size != recipe.size) {
            return false;
        }

        //Compare ingredients

        if (this.ingredients.length != recipe.ingredients.length) {
            return false;
        }

        //Check if all ingredients have been added
        if (!this.isReady() || !recipe.isReady()) {
            return false;
        }

        //Compare ingredients

        //temp is used to keep track of successful checks, as element [0] of one recipe is checked against all elements of the other recipe
        int temp = 0;
        for (int i=0; i<this.ingredients.length; i++) {
            for (int j=0; j<recipe.ingredients.length; j++) {
                if (this.ingredients[i].equals(recipe.ingredients[j])) {

                    //checks toString is same (Verifies instance variables are the same)
                    boolean sameString = true;
                    for (int q=0; q<this.ingredients[i].toString().length(); q++) {
                        if (this.ingredients[i].toString().charAt(q) != recipe.ingredients[j].toString().charAt(q)) {
                            sameString = false;
                        }
                    }
                    if (!sameString) {
                        return false;
                    }
                    temp++;
                }
            }
        }

        /*if the number of successful checks/2 is equal to the number of ingredients in the recipe then the ingredients were the same in
         both recipes*/
        if (temp/2 != this.ingredients.length-1) {
            return false;
        }

        return true;
    }

}

