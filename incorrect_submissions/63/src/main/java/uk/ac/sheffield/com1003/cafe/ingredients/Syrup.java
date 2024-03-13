package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup() {
        this.name = "syrup";
        this.amount = 10;
        this.unit= Unit.ML;
        this.flavour="vanilla";
    }
    public Syrup(String flavour,int amount){
        this.name = "syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit= Unit.ML;
    }
    public String toString() {
        return "Coffee [name=" + name + ", Syrup=" + flavour + " ]";
    }
}
