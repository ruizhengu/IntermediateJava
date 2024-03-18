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
    public boolean equals(Object contrast){
        System.out.println(ingredients[0]);

        // Check if 'contrast' is a Recipe object and not null
        if (!(contrast instanceof Recipe) || contrast == null) {
            return false;
        }
        Recipe checker = (Recipe) contrast;

        if((checker.getClass() != this.getClass()) && (this.size != checker.size)){
            return false;
        }
        if ((this.ingredients.length != checker.ingredients.length) && (this.getPrice() != checker.getPrice())){
            return false;
        }
        int i = 0;
        for (int j = 0; this.ingredients.length > j; j++){
            for (int k = 0; this.ingredients.length > k; k++){
                // if statements to check compare 'checker' and 'this.ingredients'
                if (this.ingredients[j].getClass() == checker.ingredients[k].getClass()) {
                    if (this.ingredients[j].getUnit() != checker.ingredients[k].getUnit()) {
                        return false;
                    }
                    if (this.ingredients[j].getAmount() != checker.ingredients[k].getAmount()) {
                        return false;
                    }
                    if (!this.ingredients[j].equals(checker.ingredients[k])) {
                        return false;
                    }
                    i++;
                }
            }
        }
        if (i != this.ingredients.length){
            return false;
        }

        return true;
    }
}

