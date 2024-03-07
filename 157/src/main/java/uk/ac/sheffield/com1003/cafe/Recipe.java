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
     * Checks whether two recipes are the same, despite their name
     * @param comparison Recipe to be compared
     * @return True if the two recipes are equal
     */
    public boolean equals(Recipe comparison) {
        int result = 0;
        if (this.size==comparison.size && this.getPrice()==comparison.getPrice()) {
            if (this.ingredients.length == comparison.ingredients.length) {
                if (this.isReady() && comparison.isReady()) {
                    for (int i=0;i<this.ingredients.length;i++) {
                        for (int j=0;j<comparison.ingredients.length;j++) {
                            if (this.ingredients[i].equals(comparison.ingredients[j])) {
                                result++;
                            } 
                        }
                    }
                }
            }
        }
        if (this.ingredients.length == result) {
            System.out.println("The recipes are equal");
            return true;
        }
        System.out.println("The recipes are not equal");
        return false;
    }
}
