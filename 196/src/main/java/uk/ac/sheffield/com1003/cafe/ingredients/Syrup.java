package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup(){
        this.flavour = "chocolate";
    }
    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 30;
    }
    public Syrup(String flavour, Unit unit, int amount) {
        this.flavour = flavour;
        this.unit = unit;
        this.amount = amount;
    }
    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return String.format("Syrup [unit=%s, amount=%.1f, flavour=%s]", getUnit(), getAmount(), flavour);
    }
}
