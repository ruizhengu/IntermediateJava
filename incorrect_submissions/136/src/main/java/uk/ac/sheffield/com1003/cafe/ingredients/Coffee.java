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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coffee)) {
            return false;
        }
        Coffee other = (Coffee) obj;
        if (!this.getName().equals(other.getName())) {
            return false;
        }
        if (!(this.decaf == other.decaf)) {
            return false;
        }
        if (!(this.unit == other.unit)) {
            return false;
        }
        if (Double.doubleToLongBits(this.getAmount()) != Double.doubleToLongBits(other.getAmount())) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
