package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    //Task1 - my overloaded constructor
    public Coffee(int amount) {
        this.unit = Unit.GR;
        this.amount = amount;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    //Get function for decaf. needed for equals() override function
    public boolean getDecaf() { return decaf; }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        //overrides equals method from ingredient class
        if (another == null || ! (another instanceof Coffee)) {
            return false;
        }
        if (!name.equals(((Coffee)another).getName())) {
            return false;
        }
        //check amount, unit and decaf state is the same for both objects
        if (amount != ((Coffee)another).getAmount() || unit != ((Coffee)another).getUnit() || decaf != ((Coffee)another).getDecaf()) {
            return false;
        }

        return true;
    }
}
