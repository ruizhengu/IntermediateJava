package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup(String flavour){
        this.flavour=flavour;
    }

    public Syrup(){
        this.unit=Unit.ML;
        this.amount=5;
        this.flavour="Caramel";

    }


    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == this) {
            return true;
        }
        if (!(another instanceof Syrup)) {
            return false;
        }
        Syrup s = (Syrup) another;

        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }

        return this.unit.equals(s.unit) && this.amount==s.amount && this.flavour.equals(s.flavour);
    }
}
