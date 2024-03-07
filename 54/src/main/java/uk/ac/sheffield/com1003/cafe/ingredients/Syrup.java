package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this(30, "Almond");
    }

    public Syrup(int amount){
        this(amount, "Almond");
    }

    public Syrup(String flavour) {
        this(30,flavour);
    }

    public Syrup(int amount, String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit={" + unit + "}, amount={" + amount + "}, flavour={" + flavour + "}]";
    }

}
