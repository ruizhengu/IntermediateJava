package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public String getFlavour() { return flavour; }

    /**
     * Creates a new instance of the ingredient Syrup
     * @see Syrup#Syrup(int amount)
     * @see Syrup#Syrup(String flavour)
     * @see Syrup#Syrup(int amount, String flavour)
     */
    public Syrup(){ this(8, "Golden");}
    /**
     * Creates a new instance of the ingredient Syrup
     * @param amount Amount of syrup in ml
     * @see Syrup#Syrup()
     * @see Syrup#Syrup(String flavour)
     * @see Syrup#Syrup(int amount, String flavour)
     */
    public Syrup(int amount){ this(amount, "Golden");}
    /**
     * Creates a new instance of the ingredient Syrup
     * @see Syrup#Syrup()
     * @see Syrup#Syrup(int amount)
     * @see Syrup#Syrup(int amount, String flavour)
     */
    public Syrup(String flavour){ this(8, flavour);}
    /**
     * Creates a new instance of the ingredient Syrup
     * @param amount Amount of syrup in ml
     * @param flavour Flavour of the syrup
     * @see Syrup#Syrup()
     * @see Syrup#Syrup(int amount)
     * @see Syrup#Syrup(String flavour)
     */
    public Syrup(int amount, String flavour){
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    @Override
    public boolean equals(Object other){
        // Handle edge cases
        if (!(other instanceof Syrup))
            return false;
        if (other == this)
            return true;
        // Handle super values
        boolean equals = super.equals(other);
        Syrup otherSyrup = (Syrup) other;
        return equals && (amount == otherSyrup.getAmount())
                && (unit == otherSyrup.getUnit())
                && (flavour.equals(otherSyrup.getFlavour()));
    }
}
