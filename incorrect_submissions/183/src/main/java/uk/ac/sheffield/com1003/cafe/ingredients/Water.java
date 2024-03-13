package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }


    public Water(int amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
//task5
    public boolean equals(Object other ){
        boolean alike = false;
        if (other==null || ! (other instanceof Ingredient))
        return false;
        if (name.equals(((Ingredient)other).getName()) && amount ==((Ingredient)other).getAmount() &&
         unit.equals(((Ingredient)other).getUnit()))
        alike = true;
        return alike;
    }

}
