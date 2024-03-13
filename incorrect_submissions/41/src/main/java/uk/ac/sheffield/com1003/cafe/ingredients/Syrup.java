package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    public String flavour;

    public Syrup() {
        this.amount = 5;
        /*Sets default flavour to Caramel and amount to 5 */
        this.flavour = "Caramel";
        this.unit = Unit.ML;
        this.name = "Syrup";
    }

    public Syrup(String flavour) {
        this.flavour = flavour;
        this.amount = 5;
        this.unit = Unit.ML;
        this.name = "Syrup";
    }


    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour="+ flavour +"]";
    }
    
}
