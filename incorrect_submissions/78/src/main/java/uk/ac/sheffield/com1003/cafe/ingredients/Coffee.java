package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.amount = amount;
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public Coffee(String name, Unit units, boolean decaf) {
        this.name = name;
        this.unit = units;
        this.decaf = decaf;
    }

    public Coffee(String name, Unit units, boolean decaf, int amount) {
        this.name = name;
        this.unit = units;
        this.decaf = decaf;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
