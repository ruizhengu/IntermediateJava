package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
public enum Type {CARAMEL, MOCHA, VANILLA};

private Type type = Type.VANILLA;
    public Syrup() {
        this(100, Syrup.Type.VANILLA);
    }
    public Syrup(int amount) {
        this(amount, Syrup.Type.VANILLA);
    }
    private String flavour;
    public Syrup(int amount, Type flavour){
        this.name = "Syrup";
        this.type = flavour;
        this.unit = Unit.ML;
        this.amount = amount;
    }
    public String getFlavour(){
        return flavour;
    }
    public String toString(){
        return  "Syrup [unit=" + unit + ",amount=" + amount + ",flavour=" + type + "]";

    }
}
