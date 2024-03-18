package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(){
        this("Vanilla");
    }

    public Syrup(String flavour){
        this.name = "Syrup";
        this.amount = 4;
        this.flavour = flavour;
        this.unit = Unit.ML;
    }


    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    public boolean equals(Syrup another){
        boolean same = name == another.getName() && amount == another.getAmount() && flavour == another.flavour && unit == another.unit;
        return same;
    }
}
