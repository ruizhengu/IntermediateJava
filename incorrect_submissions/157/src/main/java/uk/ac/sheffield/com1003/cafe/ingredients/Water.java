package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    public Water(int amount) {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    /**
     * Method for checking whether two Water objects are equal
     * 
     * @param another
     * @return True if both Water objects have the same instance variables
     */
    @Override
    public boolean equals(Object another) {
        if (another!=null && another instanceof Water) {
            Water comparison = (Water)another;
            if (this.name==comparison.name) {
                if (this.amount==comparison.amount) {
                    if (this.unit==comparison.unit) {
                        return true;   
                    }
                }
            }
        }
        return false;
    }
}
