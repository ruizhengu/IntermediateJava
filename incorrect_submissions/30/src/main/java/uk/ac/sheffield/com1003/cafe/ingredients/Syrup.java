package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    
    public String flavour;

    public Syrup() {
        this(10);
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "Vanilla";
    }

    public Syrup(int amount) {
        this.amount = amount;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "Vanilla";
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour(){
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        boolean same = false;
        if (another == null || ! (another instanceof Ingredient))
            return false;
        //comparing name, amount, Unit and flavour of another Ingredient object
        if (name.equals(((Ingredient)another).getName()) && 
          amount == ((Ingredient)another).getAmount() 
            && unit.equals(((Ingredient)another).getUnit()) 
              && flavour == (((Syrup)another).getFlavour()))
                    same = true;
                return same;
    }
}
