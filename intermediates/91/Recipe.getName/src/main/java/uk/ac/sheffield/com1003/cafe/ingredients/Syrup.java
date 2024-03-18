package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this(100, "Vanilla");
    }

    public Syrup(String instanceFlavour) {this(100, instanceFlavour); }

    public Syrup(int instanceAmount) {
        this(instanceAmount, "Vanilla");
    }

    public Syrup(int instanceAmount, String instanceFlavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = instanceAmount;
        this.flavour = instanceFlavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * Compares whether two objects are equal
     * @return True if both objects are Syrup objects with equal variables, false otherwise
     */
    public boolean equals(Object otherObject)
    {
        if (otherObject == null) { return false; }
        if (!(otherObject instanceof  Ingredient)) { return false; }
        if (this.getClass() != otherObject.getClass()) { return false; }
        Ingredient tempIngredient = (Ingredient) otherObject;
        if (this.getName() != tempIngredient.getName()) { return false; }

        Syrup tempSyrup = (Syrup) otherObject;
        if (this.unit == tempSyrup.unit && this.amount == tempSyrup.amount
                && this.flavour == tempSyrup.flavour) { return true; }
        else { return false; }
    }
}
