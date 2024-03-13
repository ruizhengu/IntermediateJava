package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() { this("Caramel"); }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * Compares two Syrup objects to see if have equivalent data field values
     *
     * @param another Takes in another Syrup instance as an input value
     * @return Returns true if the name, amount, unit and {@link Syrup#flavour} are the same; return false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return this.name.equals(((Syrup)another).getName()) && this.amount == ((Syrup)another).getAmount() &&
                this.unit.equals(((Syrup)another).getUnit()) && this.flavour.equals(((Syrup)another).flavour);
    }
}
