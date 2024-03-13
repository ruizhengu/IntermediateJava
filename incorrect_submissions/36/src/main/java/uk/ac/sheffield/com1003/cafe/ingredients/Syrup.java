package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    // Default constructor
    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = "Caramel";
    }

    public Syrup ( int amount, String flavour){
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public int getAmount() { return this.amount; }

    @Override
    public Unit getUnit() { return this.unit; }


    public String getFlavour() { return this.flavour; }
    @Override
    public String toString() { return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";}

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return name.equals(((Syrup)another).getName()) &&
                amount == ((Syrup) another).getAmount() &&
                unit.equals(((Syrup)another).getUnit()) &&
                flavour.equals(((Syrup) another).getFlavour());
    }
}
