package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    // Overload method
    public Coffee(int amount){
        this.amount = amount;
    }

    public Coffee( int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public int getAmount() { return this.amount; }

    @Override
    public Unit getUnit() { return this.unit; }

    public boolean isDecaf() { return false;}

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        return name.equals(((Coffee)another).getName()) &&
                amount == ((Coffee) another).getAmount() &&
                unit.equals(((Coffee)another).getUnit()) &&
                decaf == ((Coffee)another).isDecaf();
    }
}

