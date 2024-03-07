package uk.ac.sheffield.com1003.cafe.ingredients;

// create a new syrup ingredient
public class Syrup extends Ingredient {
	// assigns the different possible types of syrup that can be selected using an enum
    public enum Type { GOLDEN, CHOCOLATE, STRAWBERRY};
    private Type type = Type.GOLDEN;

    // initialise syrup object with 100 ml golden syrup
    public Syrup() {
        this(100, Type.GOLDEN);
    }

    // create argument amount for Syrup constructor
    public Syrup(int amount) {
        this(amount, Type.GOLDEN);
    }

    // set object with required variables
    public Syrup(int amount, Type type) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }

    // string reputation for Syrup object when toString() is called
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}


