package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount) { this(amount, false); }

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

    /**
     * Compares whether two objects are equal
     * @return True if both objects are Coffee objects with equal variables, false otherwise
     */
    public boolean equals(Object otherObject) {
        if (otherObject == null) { return false; }
        if (!(otherObject instanceof  Ingredient)) { return false; }
        if (this.getClass() != otherObject.getClass()) { return false; }
        Ingredient tempIngredient = (Ingredient) otherObject;
        if (this.getName() != tempIngredient.getName()) { return false; }

        Coffee tempCoffee = (Coffee) otherObject;
        if (this.getUnit() == tempCoffee.getUnit() && this.getAmount() == tempCoffee.getAmount()
                && this.decaf == tempCoffee.decaf) { return true; }
        else { return false; }
    }
}


