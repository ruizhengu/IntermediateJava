package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    /**
     * Constructor that initialises the default amount to 10 and flavour of syrup to vanilla
     */
    public Syrup() {this(10,"Vanilla");}

    /**
     * Constructor that takes in amount of syrup as a parameter
     * Initialises default flavour to be vanilla
     * @param amount The amount of syrup
     */
    public Syrup (int amount) {this(amount, "Vanilla");}

    /**
     * Constructor that takes in amount and flavour of syrup as a parameter
     * Initialises name, amount, flavour and sets default unit of syrup as ML
     * @param amount The amount of syrup
     * @param flavour The flavour of syrup
     */
    public Syrup (int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * equals() method to compare two syrup objects
     * Checks if the two objects are the same class, have the same flavour, amount, and unit
     * @param o The object passed into the parameter of the method, to be compared
     * @return True is returned if class, flavour, amount and unit are the same, or false is returned otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;}

        Syrup s = (Syrup) o;

        if (!(this.flavour.equals(s.flavour)) || !(Integer.compare(amount,s.amount) == 0) || !(this.unit == s.unit)) {
            System.out.println("Syrup is not the same");
        }

        return this.flavour.equals(s.flavour) && Integer.compare(amount,s.amount) == 0 && this.unit == s.unit;

    }
}
