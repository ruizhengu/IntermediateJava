package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

//    private int i = 0;

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

    public boolean equals(Object estimate) {

        if (!(estimate instanceof Recipe) || estimate == null) {
            return false;
        }
        Recipe test = (Recipe) estimate;

        if ((test.getClass() != this.getClass())) {
            return false;
        }
        if ((test.ingredients.length != this.ingredients.length)) {
            return false;
        }
        if ((test.getPrice() != this.getPrice())) {
            return false;
        }
        if ((test.size != this.size)) {
            return false;
        }
        int testing = 0;
        for (int i = 0; this.ingredients.length > i; i++) {
            for (int j = 0; this.ingredients.length > j; j++) {
                if (this.ingredients[i].getClass() == test.ingredients[j].getClass()) {
                    if (this.ingredients[i].getUnit() != test.ingredients[j].getUnit()) {
                        return false;
                    }
                    if (this.ingredients[i].getAmount() != test.ingredients[j].getAmount()) {
                        return false;
                    }
                    if (!this.ingredients[i].equals(test.ingredients[j])) {
                        return false;
                    }
                    testing++;
                }
            }
        }
        if (this.ingredients.length != testing) {
            return false;
        }
        return true;
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
