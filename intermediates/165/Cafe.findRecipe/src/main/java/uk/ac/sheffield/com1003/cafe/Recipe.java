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

    public Size getSize(){
        return this.size;
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


    public Ingredient[] getIngredients(){
        return this.ingredients;
    }
    public boolean equals(Recipe another){

        Ingredient[] thisIngredients = this.getIngredients();
        Ingredient[] anotherIngredients = another.getIngredients();
        boolean ingredientsEqual = false;
        boolean sizeEqual;
        boolean bothHaveIngredient = false;

        //set ingredientsEqual to true if all of the ingredients in the current
        //recipe can also be found in the one it is being compared to
        if (thisIngredients.length == anotherIngredients.length){
            ingredientsEqual = true;
            for (int i=0; i < thisIngredients.length; i++){
                for (int j=0; i < thisIngredients.length; i++){
                    bothHaveIngredient = false;
                    if (thisIngredients[i].equals(anotherIngredients[j]) == true){
                        bothHaveIngredient = true;
                    }
                }
                if (bothHaveIngredient == false){
                    ingredientsEqual = false;
                }
            }
        }

        sizeEqual = (another.getSize() == this.getSize());
        System.out.println("ingredients, size");
        System.out.println(ingredientsEqual);
        System.out.println(sizeEqual);

        if (ingredientsEqual && sizeEqual){
            return true;
        } else{
            return false;
        }


            

        
    }
}
