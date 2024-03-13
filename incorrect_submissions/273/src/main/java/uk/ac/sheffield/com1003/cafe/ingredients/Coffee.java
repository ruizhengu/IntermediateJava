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
    public boolean equals(Object o){
        if (o == null || ! (o instanceof Coffee))
            return false;
        if (! this.name.equals(((Coffee)o).getName())){
            return false;
        }
        if (! this.unit.equals(((Coffee)o).getUnit())){
            return false;
        }
        if (this.decaf != ((Coffee)o).getDecaf()){
            return false;
        }
        if (this.amount != ((Coffee)o).getAmount()){
            return false;
        }

        return true;
    }

    private boolean getDecaf() {
        return decaf;
    }
}
