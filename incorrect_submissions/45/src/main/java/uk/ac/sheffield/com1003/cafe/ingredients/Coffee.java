package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean getDecaf() {return decaf;}

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Coffee)) {
            return false;
        }

        Coffee other = (Coffee)another;
        boolean nameCheck = name.equals(other.getName());
        boolean amountCheck = amount == other.getAmount();
        boolean unitCheck = unit == other.getUnit();
        boolean decafCheck = decaf == other.getDecaf();

        return nameCheck && amountCheck && unitCheck && decafCheck;
    }

}
