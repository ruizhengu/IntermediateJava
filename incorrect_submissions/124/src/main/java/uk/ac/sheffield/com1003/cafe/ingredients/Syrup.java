package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    public Syrup() { this(10, "Apple"); }

    public Syrup(int amount) { this(amount, "Apple"); }

    public Syrup(String flavour) { this(10, flavour); }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        // Check objects are the same type (null will return false here)
        if (!(another instanceof Syrup))
            return false;

        // Check specific instance variables
        Syrup anotherSyrup = (Syrup) another;
        return (name.equals(anotherSyrup.name) &&
                amount == anotherSyrup.amount &&
                unit == anotherSyrup.unit &&
                flavour.equals(anotherSyrup.flavour));
    }
}
