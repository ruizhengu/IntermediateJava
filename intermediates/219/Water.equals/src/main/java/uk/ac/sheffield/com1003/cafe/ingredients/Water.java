package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() { this(30); }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object obj) {
        //Check that object is the same class
        if(obj == null || !(obj instanceof Water)){
            return false;
        }

        //Get object as recipe class
        Water other = (Water) obj;

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

        return true;
    }
}
