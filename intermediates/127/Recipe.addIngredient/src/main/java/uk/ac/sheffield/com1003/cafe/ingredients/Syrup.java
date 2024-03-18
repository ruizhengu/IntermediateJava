package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this("Vanilla",20);
    }

    public Syrup(String flavour) {
        this(flavour,20);
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }
    
    public String getFlavour(){
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    //equals checks for syrup flavour
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        if (name.equals(((Ingredient)another).getName()))
        {
            if (this.amount == ((Ingredient)another).getAmount())
                if (this.flavour.equals(((Syrup)another).getFlavour())) return true;;
        }
        return false;
    }
}
