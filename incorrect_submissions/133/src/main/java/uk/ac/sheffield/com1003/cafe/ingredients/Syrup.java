package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private enum Flavour { SWEET, FRUITY, SALTY };

    private Flavour flavour = Flavour.SWEET;
    public Syrup(){
        this(30, Flavour.SWEET);
    }

    public Syrup(int amount){
        this(amount,Flavour.SWEET);
    }

    public Syrup(int amount, Flavour flavour){
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}