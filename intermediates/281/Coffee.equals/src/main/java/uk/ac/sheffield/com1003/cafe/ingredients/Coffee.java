package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount) {
        this(amount, false);
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
    public boolean equals(Object object) {
        // Checks if the both objects are identical
        if (this == object) return true;

        // Checks if the object is null
        if (object == null) return false;

        // Ensures the objects are of the same class
        if (!(object instanceof Coffee)) return false;
        Coffee coffee = (Coffee) object;

        // Checks if all the properties of the class are equal or not
        return (this.name.equals(coffee.name)
                && this.amount == coffee.amount
                && this.unit.equals(coffee.unit)
                && this.decaf == coffee.decaf);
    }
}
