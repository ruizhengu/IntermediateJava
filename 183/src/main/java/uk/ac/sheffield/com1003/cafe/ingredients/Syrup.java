package uk.ac.sheffield.com1003.cafe.ingredients;
//task 6
public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this.amount = 20;
    }

    public Syrup(int amount){
        this.amount=amount;
        flavour="Strawberry";
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = "Strawberry";
    }

    public String getFlavour(){
        return flavour;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    public boolean equals(Object other ){
        boolean alike = false;
        if (other==null || ! (other instanceof Ingredient))
        return false;
        if (name.equals(((Ingredient)other).getName()) && amount ==((Ingredient)other).getAmount() && 
        unit.equals(((Ingredient)other).getUnit()) && flavour == (((Syrup)other).getFlavour()))
        alike = true;
        return alike;
    }
}
