package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() { this(10, "Vanilla"); }

    public Syrup(int amount) {
        this(amount, "Vanilla");
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object obj) {
        //Check that object is the same class
        if(obj == null || !(obj instanceof Syrup)){
            return false;
        }

        //Get object as recipe class
        Syrup other = (Syrup) obj;

        //Check name is the same
        if(this.name != other.name){
            return false;
        }

        //Check units the same
        if(this.unit != other.unit){
            return false;
        }

        //Check amount the same
        if(this.amount != other.amount){
            return false;
        }

        //Check flavours are same
        if(this.flavour != other.flavour){
            return false;
        }

        return true;
    }
}
