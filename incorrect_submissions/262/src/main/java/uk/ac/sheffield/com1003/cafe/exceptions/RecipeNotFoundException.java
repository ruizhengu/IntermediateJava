package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {

	private String recipe;
	
    /**
     * Constructor which takes a non existing recipe a name
     */
	public RecipeNotFoundException(String recipe)	{
		this.recipe = recipe;
	}
	
	
    /**
     * Getter for non-existing recipe name
     * @return non-existing recipe name
     */
	public String getRecipe()	{
		return recipe;
	}
}
