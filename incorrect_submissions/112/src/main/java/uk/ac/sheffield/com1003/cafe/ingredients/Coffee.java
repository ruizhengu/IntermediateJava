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

    public boolean getDecaf() {
        return decaf;
    }


    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other))
            return false;

        Coffee otherIngredient = (Coffee)other;
        return decaf == otherIngredient.getDecaf();
    }
}
