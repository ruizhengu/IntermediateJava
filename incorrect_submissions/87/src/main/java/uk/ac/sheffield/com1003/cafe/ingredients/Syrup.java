package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    public Syrup(){
        this.name="Syrup";
        this.unit=Unit.ML;
        this.flavour="Honey";
    }
    public Syrup(String flavour) {
        this.name="Syrup";
        this.unit=Unit.ML;
        this.flavour=flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}
