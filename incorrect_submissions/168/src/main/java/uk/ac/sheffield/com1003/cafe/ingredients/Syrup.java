package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup() {
        this(10, "vanilla");
    }

    public Syrup(int amount) {
        this(amount, "vanilla");
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() { return flavour; }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (! (another instanceof Syrup))
            return false;
        return name.equals(((Syrup)another).getName()) &&
                unit.equals(((Syrup)another).getUnit()) &&
                amount == ((Syrup)another).getAmount() &&
                flavour.equals(((Syrup)another).getFlavour());
    }
}
