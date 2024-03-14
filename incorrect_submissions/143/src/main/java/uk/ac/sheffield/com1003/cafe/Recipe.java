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

    /**
     * checks if recipes are equal except for the name
     * @param o The object
     * @return True if the price ,size and ingredients
     * (amount , unit , name , and specific instance variables like milk type and syrup flavour) are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipeCompare = (Recipe) o;
        if (this.ingredients.length != recipeCompare.ingredients.length) return false;

        for (Ingredient ingredient : this.ingredients) {
            boolean foundMatch = false;
            int i = 0;
            while (!foundMatch && i < recipeCompare.ingredients.length) {
                Ingredient otherIngredient = recipeCompare.ingredients[i];
                if (ingredient.toString().equals(otherIngredient.toString())) {
                    if(this.getPrice() == recipeCompare.getPrice() && this.size == recipeCompare.size){
                        foundMatch = true;
                    }
                }
                i++;
            }
            if (!foundMatch) return false;
        }

        return true;
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
}
