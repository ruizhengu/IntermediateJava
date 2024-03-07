package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup() { this(30, "Caramel");}

    public Syrup(String flavour) { this(30, flavour);}

    // Task 1 Subtask 1
    public Syrup (int amount, String flavour) {
        this.amount = amount;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
