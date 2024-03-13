package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    protected String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "Vanilla";
        this.amount = 20;
    }

    public Syrup(String _flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = _flavour;
        this.amount = 20;
    }

    public Syrup(String _name, String _flavour) {
        this.name = _name;
        this.unit = Unit.ML;
        this.flavour = _flavour;
        this.amount = 20;
    }

    public Syrup(String _name, String _flavour, int _amount) {
        this.name = _name;
        this.unit = Unit.ML;
        this.flavour = _flavour;
        this.amount = _amount;
    }

    public String getFlavour() {return flavour;}

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Syrup)) {
            return false;
        }

        Syrup other = (Syrup)another;
        boolean nameCheck = name.equals(other.getName());
        boolean amountCheck = amount == other.getAmount();
        boolean unitCheck = unit == other.getUnit();
        boolean flavourCheck = flavour.equals(other.getFlavour());

        return nameCheck && amountCheck && unitCheck && flavourCheck;
    }

}
