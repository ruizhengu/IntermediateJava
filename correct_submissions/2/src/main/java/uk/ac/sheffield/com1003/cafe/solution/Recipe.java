package uk.ac.sheffield.com1003.cafe.solution;

import uk.ac.sheffield.com1003.cafe.solution.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Ingredient;

/**
 * Represents a recipe for a drink or food item in a cafe.
 * A recipe is made up of a name, price, size, and a list of ingredients.
 */

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
     * Compares this Recipe object with the specified object for equality.
     *
     * This method checks if the given object is a Recipe instance and if it has the same price,
     * size, and ingredients as this Recipe object. Additionally, it prints out the differences
     * between the two recipes if any are found.
     *
     * @param obj the object to be compared for equality with this Recipe
     * @return true if the specified object is equal to this Recipe; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Recipe)) {
            return false;
        }
        boolean totalResult = true;
        boolean ingredientSame =true;
        //Check the elements one by one as required by the task
        Recipe otherDrink = (Recipe) obj;
        if (!(this.isReady()&&otherDrink.isReady())){
            //System.out.println("Please check the recipe(s) for completeness!");
            return false;
        }

        if (this.price != otherDrink.price) {
            /*
            System.out.println("Prices are different:");
            System.out.println("    "+this.name+" - "+this.price);
            System.out.println("    "+otherDrink.name+" - "+otherDrink.price);
             */
            totalResult = false;
        }

        if (this.size != otherDrink.size) {
            /*
            System.out.println("Sizes are different:");
            System.out.println("    "+this.name+" - "+this.size);
            System.out.println("    "+otherDrink.name+" - "+otherDrink.size);
             */
            totalResult = false;
        }

        if (this.ingredients.length != otherDrink.ingredients.length) {
            /*
            System.out.println("Number of ingredients are different:");
            System.out.println("    "+this.name+" - "+this.ingredients.length);
            System.out.println("    "+otherDrink.name+" - "+otherDrink.ingredients.length);
             */
            totalResult = false;
        }

        //This loop is used to iterate through each ingredient in the current drink object one by one
        for (Ingredient ingredient : this.ingredients) {
            boolean found = false;
            //Loop through each ingredient in otherDrink to find if there is an item that matches the current ingredient
            for (Ingredient otherIngredient : otherDrink.ingredients) {
                //If a match is found, the flag variable found is updated to true and the inner loop is jumped
                if (ingredient.equals(otherIngredient)) {
                    found = true;
                    break;
                }
            }
            //Print out details after discovering differences in composition
            if (!found) {
                /*
                if (ingredientSame){
                    System.out.println("Ingredients are different:");
                    System.out.print("    "+this.name+" -");
                    for (Ingredient ingredientCategory: this.ingredients) {
                        System.out.print(" "+ingredientCategory.getName());
                    }
                    System.out.println(" ");
                    System.out.print("    "+otherDrink.name+" -");
                    for (Ingredient ingredientCategory: otherDrink.ingredients) {
                        System.out.print(" "+ingredientCategory.getName());
                    }

                    System.out.println(" ");
                    System.out.println("    ==========");
                    System.out.println("    The details of differences in ingredients - "+this.name+":");
                }

                System.out.println("    "+ingredient.toString());
                 */
                ingredientSame = false;
                totalResult = false;
            }
        }
        //If found a difference in the recipe, print out the part that differs of otherDrink.
        /*
        if (!ingredientSame) {
            System.out.println("    The details of differences in ingredients - " + otherDrink.name + ":");
            for (Ingredient ingredient : otherDrink.ingredients) {
                boolean found = false;
                for (Ingredient otherIngredient : this.ingredients) {
                    if (ingredient.equals(otherIngredient)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("    "+ingredient.toString());
                }
            }
        }
        */

        return totalResult;
    }
}
