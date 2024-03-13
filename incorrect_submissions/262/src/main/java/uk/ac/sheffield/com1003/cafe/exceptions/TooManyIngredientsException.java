package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
	
	private int numIngredients;
	private int maxNumIngredients;

	
	/**
     * Constructor which takes the maximum number of ingredients
     * and the number attempted ingredients to be added
     */
	public TooManyIngredientsException(int maxNumIngredients, int numIngredients) {
		this.numIngredients = numIngredients;
		this.maxNumIngredients = maxNumIngredients;
	}


	 /**
     * Getter for number of ingredients
     * @return the number of ingredients
     */
	public int getNumIngredients()	{
		return numIngredients;
	}
	
	 /**
     * Getter for the maximum number of ingredients
     * @return the max number of ingredients
     */
	public int getMaxNumIngredients()	{
		return maxNumIngredients;
	}
	
}
