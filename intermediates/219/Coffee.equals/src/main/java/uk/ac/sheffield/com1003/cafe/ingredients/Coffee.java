package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() { this(8, false); }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object obj) {
        //Check that object is the same class
        if(obj == null || !(obj instanceof Coffee)){
            return false;
        }

        //Get object as recipe class
        Coffee other = (Coffee) obj;

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

        //Check decaf same
        if(this.decaf != other.decaf){
            return false;
        }

        return true;
    }
}
