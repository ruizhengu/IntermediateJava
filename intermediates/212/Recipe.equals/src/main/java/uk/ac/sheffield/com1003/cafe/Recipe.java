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


    @Override
    public boolean equals(Object recipe) {
        if (recipe == this) {
            return true;
        }
    
        if (!(recipe instanceof Recipe)) {
            return false;
        }

        Recipe nRecipe = (Recipe) recipe;
        boolean isSameIngredient = false;

        if (this.size == nRecipe.size && 
        this.getPrice() == nRecipe.getPrice() &&
        this.ingredients.length == nRecipe.ingredients.length) {
            int i = 0;

            while (i < this.ingredients.length && isSameIngredient == false) {
                int j = 0;

                while (j < nRecipe.ingredients.length && isSameIngredient == false) {
                    // System.out.println("CLASS: " + this.ingredients[i].getName());
                    // System.out.println("COMPARED WITH: " + recipe.ingredients[j].getName());
                    // System.out.println();

                    if(this.ingredients[i].getClass() == nRecipe.ingredients[j].getClass()) {
                        System.out.println("INGREDIENT " +  (i+1) + " : "  + ingredients[i].equals(nRecipe.ingredients[j]));
                        isSameIngredient = ingredients[i].equals(nRecipe.ingredients[j]);
                        
                        if (isSameIngredient != true) {
                            j = nRecipe.ingredients.length;
                        }
                    } else {
                        j++;
                        if (j == nRecipe.ingredients.length) {
                            isSameIngredient = false;
                            System.out.println("INGREDIENT " + (i+1) + ": NOT SAME");
                        }
                    }
                }

                i++;

                if (isSameIngredient == true && i != this.ingredients.length) {
                    isSameIngredient = false;
                } 
            }
            
            return isSameIngredient;

        } else {
            return false;
        }
    }
}
