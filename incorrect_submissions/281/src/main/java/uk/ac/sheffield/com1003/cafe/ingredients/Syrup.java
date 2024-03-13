package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this(10, "Maple");
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() { return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour" + flavour + "]"; }

    @Override
    public boolean equals(Object object) {
        // Checks if the both objects are identical
        if (this == object) return true;

        // Checks if the object is null
        if (object == null) return false;

        // Ensures the objects are of the same class
        if (!(object instanceof Syrup)) return false;
        Syrup syrup = (Syrup) object;

        // Checks if all the properties of the class are equal or not
        return (this.name.equals(syrup.name)
            && this.amount == syrup.amount
            && this.unit.equals(syrup.unit)
            && this.flavour.equals(syrup.flavour));
    }
}
