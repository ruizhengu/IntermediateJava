package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }

    //Task 1 - my overloaded constructor
    public  Water(int amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        //overrides equals method from ingredient class

        //checks that other object is also a water object and not null
        if (another == null || ! (another instanceof Water)) {
            return false;
        }
        if (amount != ((Water)another).getAmount() || unit != ((Water)another).getUnit()) {
            return false;
        }

        return true;
    }
}
