package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
        this.amount = 8;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public Coffee(int amount){
        this(amount,false);
    }

    /*
     * Overriding to check if param (coffee) is equal to object and the water ingredient is the same with the
     * recipe customer is asking, return false if the class is different
     * Compare if all the details such as amount, unit, name and decaf is the same, return true if everything is same
     */
    public boolean equals(Object coffee){
        if (coffee == this)
            return true;
        if(coffee.getClass() != this.getClass()) {
            return false;
        }
            Coffee coffeeCompared = (Coffee) coffee;
            if ((coffeeCompared.unit == this.unit) && (coffeeCompared.amount == this.amount)
                && (coffeeCompared.name.equals(this.name)) && (coffeeCompared.decaf == this.decaf)){
            return true;
        }

            return false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
