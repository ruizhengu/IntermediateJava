package uk.ac.sheffield.com1003.cafe.ingredients;
/** 
 * Represents syrup ingredient in a Recipe
*/
public class Syrup extends Ingredient {

    private String flavour;

    static final int DEFAULT_AMOUNT = 30;
    static final String DEFAULT_FLAVOUR = "Honey";

    public Syrup() {
        this(DEFAULT_AMOUNT,DEFAULT_FLAVOUR);
    }

    public Syrup(int amount) {
        this(amount, DEFAULT_FLAVOUR);
    }

    public Syrup(String flavour) {
        this(DEFAULT_AMOUNT, flavour);
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount > 0 ? amount : DEFAULT_AMOUNT;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit="+unit+", amount="+amount+", flavour="+flavour+"]";
    }
}
