package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
    	this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }
    
    public Water(int amount) {
    	this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Water)) {
            return false;
        }
        Water other = (Water) obj;
        if (!this.getName().equals(other.getName())) {
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
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
