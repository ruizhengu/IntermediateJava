package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    public enum Flavour { VANILLA, CINNAMON, CARAMEL, GINGERBREAD };
    private Flavour flavour = Flavour.VANILLA;

    public  Syrup(){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 20;
        this.flavour = Flavour.VANILLA;
    }

    public Syrup(int amount, Flavour flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public Flavour getFlavour() {
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
