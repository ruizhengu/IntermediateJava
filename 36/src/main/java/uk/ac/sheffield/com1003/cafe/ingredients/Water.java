package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }

    // Overload method
    public Water(int amount){ this.amount = amount; }

    public Water(String name, Unit unit, int amount){
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String getName() { return this.name;}

    @Override
    public Unit getUnit() { return this.unit;}

    @Override
    public int getAmount() { return this.amount;}

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        return name.equals(((Water)another).getName()) &&
                unit.equals(((Water)another).getUnit()) &&
                amount == ((Water) another).getAmount();
    }
}
