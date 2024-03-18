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


//  Equals method for Water that verifies whether the objects are of the same class
//  and contain the same values defined in the constructor
    public boolean equals(Object water) {
        if (water == this) {
            return true;
        }

        if (! (water.getClass() == this.getClass()) ) {
            return false;
        }

        Water w = (Water) water;

        if (w.unit == this.unit && w.name == this.name
                && w.amount == this.amount) {
            System.out.println("They are the same in water");
            return true;
        }
        else {
            System.out.println("They are not the same in water");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
