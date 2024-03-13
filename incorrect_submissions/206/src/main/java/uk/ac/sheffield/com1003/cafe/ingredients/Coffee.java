package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

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
    public boolean equals(Object ingredient){
        if (ingredient == null || ! (ingredient instanceof Coffee)) {
            return false;
        } else {
            if (((Coffee) ingredient).decaf == decaf &&
                    ((Coffee) ingredient).name == name &&
                    ((Coffee) ingredient).amount == amount &&
                    ((Coffee) ingredient).unit == unit) {
                return true;
            } else {
                return false;
            }
        }
    }
}
