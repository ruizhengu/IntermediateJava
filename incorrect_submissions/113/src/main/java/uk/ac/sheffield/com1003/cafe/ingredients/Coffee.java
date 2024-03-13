package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public boolean getDecaf() {return this.decaf;}

    public Coffee() {
        this.amount = 8;
    }

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

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return (name.equals(((Ingredient)another).getName()) &&
                amount == ((Ingredient)another).getAmount() &&
                unit == ((Ingredient)another).getUnit() &&
                decaf == ((Coffee)another).getDecaf());
    }
}
