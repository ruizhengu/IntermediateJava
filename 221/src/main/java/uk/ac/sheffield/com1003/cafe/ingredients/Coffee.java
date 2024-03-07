package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);

    }

    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee (int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public boolean equals(Object another) {
        if (super.equals(another) && another instanceof Coffee) {
            Coffee otherIngredient = (Coffee) another;
            return (unit.equals(otherIngredient.unit)
                    && amount == otherIngredient.amount
                    && decaf == otherIngredient.decaf);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
