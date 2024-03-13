package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    /**
     * Find recipe with same instance and compare it to the object method is called from
     * @param another object being compared
     * @return Returns true if it is the same class and all variables are the same; false otherwise
     */
    @Override
    public boolean equals(Object another) {
        //check if class is the same
        if (super.equals(another)) {
            Water other = (Water) another;
            //compare variables
            if (this.getName() == other.getName()
                    && this.amount == other.amount
                    && this.unit == other.unit){

                return true;
            }
        }
        return false;
    }
}
