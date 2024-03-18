package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    /**
     * Water as ingredient with custom amount in millilitres
     *
     * @param amount Amount of water in millilitres
     */
    public Water(int amount){
        this("Water", amount, Unit.ML);
    }

    public Water(String name, int amount, Unit unit){
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || ! (obj instanceof Water))
            return false;
        Water wObj = (Water) obj;
        // return true if same amount and units.
        super.equals(wObj);
        return super.equals(wObj) &
                wObj.getAmount() == this.getAmount() &&
                wObj.getUnit() == this.getUnit();
    }
}
