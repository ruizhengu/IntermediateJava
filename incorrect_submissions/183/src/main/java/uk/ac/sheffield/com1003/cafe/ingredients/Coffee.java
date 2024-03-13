package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public boolean getDecaf(){
        return decaf;
    }

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount){
        this.amount=amount;
    }

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
//task5
    public boolean equals(Object other ){
        boolean alike = false;
        if (other==null || ! (other instanceof Ingredient))
        return false;
        if (name.equals(((Ingredient)other).getName()) && amount ==((Ingredient)other).getAmount() && 
        unit.equals(((Ingredient)other).getUnit()) && decaf == (((Coffee)other).getDecaf()))
        alike = true;
        return alike;
    }

}
