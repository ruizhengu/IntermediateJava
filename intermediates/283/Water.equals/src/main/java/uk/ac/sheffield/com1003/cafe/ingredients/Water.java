package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (!super.equals(another)) return false;
        
        // Check the ingredients are the same type
        if (!(another instanceof Water))
            return false;
        
        Water water2 = (Water)another;
        return (unit == water2.unit && amount == water2.amount);
    }
}
