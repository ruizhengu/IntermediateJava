package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Constructor that initialises the default amount to 8 and decaf to false
     */
    public Coffee() {this(8,false);}

    /**
     * Constructor that takes in amount of coffee as a parameter
     * Initialises decaf to be false
     * @param amount The amount of coffee
     */
    public Coffee(int amount) {this(amount,false);}

    /**
     * Constructor that takes in amount and whether it is decaf or not as parameters
     * Initialises name, amount, decaf and sets default unit of coffee as GR
     * @param amount
     * @param decaf
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    /**
     * equals() method to compare two coffee objects
     * Checks if the two objects are the same class, amount, unit and whether it is decaf or not
     * @param o The object passed into the parameter of the method, to be compared
     * @return True is returned if class, decaf, amount and unit are the same, or false is returned otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;}

        Coffee c = (Coffee) o;

        if (!(this.decaf == c.decaf) || !(Integer.compare(amount,c.amount) == 0) || !(this.unit == c.unit)) {
            System.out.println("Coffee is not the same");
        }

        return this.decaf == c.decaf && Integer.compare(amount,c.amount) == 0 && this.unit == c.unit;

    }
}
