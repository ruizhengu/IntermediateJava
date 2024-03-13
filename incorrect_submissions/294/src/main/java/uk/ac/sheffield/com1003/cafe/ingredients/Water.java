package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }


    /**
     * Compares this Water object with another object to see if they have the same name, unit, and amount.
     * @param another the object to compare with this Water object
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object another) {

        // Check if the other object is an instance of the Water class
        if (another instanceof Water) {

            // Cast the other object to a Water object and store it in a variable
            Water otherWater = (Water) another;

            // Compare the name, unit, and amount of the two Water objects
            if (name.equals(otherWater.getName()) && unit.equals((otherWater.getUnit())) && amount == otherWater.getAmount()) {
                return true;
            }

            // If any of the properties are not equal, return false
            return false;
        }
        // If the other object is not a Water object, return false
        return false;
    }
}
