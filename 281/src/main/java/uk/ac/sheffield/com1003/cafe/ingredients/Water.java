package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount){
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object object) {
        // Checks if the both objects are identical
        if (this == object) return true;

        // Checks if the object is null
        if (object == null) return false;

        // Ensures the objects are of the same class
        if (!(object instanceof Water)) return false;
        Water water = (Water) object;

        // Checks if all the properties of the class are equal or not
        return (this.name.equals(water.name)
                && this.amount == water.amount
                && this.unit.equals(water.unit));
    }
}
