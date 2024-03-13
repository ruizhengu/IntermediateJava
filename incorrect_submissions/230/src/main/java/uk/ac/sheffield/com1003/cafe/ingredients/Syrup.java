package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient
{
    private String flavour;
    /**
     * Constructor that initialises name to Toffee amount to 50 and unit to ML.
     */
    public Syrup()
    {
        this("Toffee");
    }
    /**
     * Constructor that takes the flavour as a parameter.
     */
    public Syrup(String flavour)
    {
        unit = Unit.ML;
        amount = 50;
        this.flavour = flavour;
    }
    /**
     * Method that returns all the instance information in a string.
     */
    @Override
    public String toString()
    {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
