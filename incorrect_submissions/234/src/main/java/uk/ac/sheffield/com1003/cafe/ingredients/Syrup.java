package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Salted caramel");
    }

    public Syrup(String flavour) {
        this(flavour, 1000000);
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    public String getFlavour() {
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Syrup))
            return false;
        return this.getUnit().equals(((Syrup) another).getUnit()) && this.getAmount() == ((Syrup) another).getAmount()
                && this.getFlavour().equals(((Syrup) another).getFlavour())
                && this.getName() == ((Syrup) another).getName();
    }
}
