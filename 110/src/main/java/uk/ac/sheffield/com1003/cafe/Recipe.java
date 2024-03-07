package uk.ac.sheffield.com1003.cafe;

import java.lang.reflect.Field;
// import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class Recipe {
    public enum Size {
        SMALL, REGULAR, LARGE
    };

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
     *
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the
     *                                     recipe would be exceeded
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
     *
     * @return True if all ingredients of the recipe have been added and false
     *         otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null)
            return false;

        if (obj instanceof Recipe) {
            Recipe ortherRecipe = (Recipe) obj;

            /* same size */
            if (size != ortherRecipe.size)
                return false;

            /* same price */
            if (price != ortherRecipe.price)
                return false;

            /* same number of ingredient */
            if (ingredients.length != ortherRecipe.ingredients.length)
                return false;

            /* all ingredients are set */
            if (!isReady() || !ortherRecipe.isReady())
                return false;

            /* contain the same ingredients */
            boolean contain = false;
            for (Ingredient ingredient : ingredients) {
                contain = false;
                for (Ingredient ortherIngredient : ortherRecipe.ingredients) {
                    if (ingredient.equals(ortherIngredient)) {
                        /**
                         * fields = superFields + subFields
                         */
                        Field[] superFields = Ingredient.class.getDeclaredFields();
                        Field[] subFields = ingredient.getClass().getDeclaredFields();
                        Field[] fields = new Field[superFields.length + subFields.length];
                        System.arraycopy(superFields, 0, fields, 0, superFields.length);
                        System.arraycopy(subFields, 0, fields, superFields.length, subFields.length);

                        /**
                         * compare every variables between the ingrdients
                         */
                        for (Field field : fields) {
                            field.setAccessible(true);
                            try {
                                if (field.get(ingredient) != field.get(ortherIngredient))
                                    return false;
                            } catch (IllegalArgumentException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }

                        contain = true;
                        break;
                    }
                }
                if (!contain) {
                    return false;
                }
            }
            return contain;

        } else { /* The obj is not Recipe class, the result is false */
            return false;
        }
    }
}
