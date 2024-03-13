package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public Coffee(int amount) {
        this(amount, false);
    }

//equals method for coffee
    public boolean equals(Object coffee) {
        if (coffee == this) {
            return true;
        }

        if (! (coffee.getClass() == this.getClass()) ) {
            return false;
        }

        Coffee c = (Coffee) coffee;

        if (c.unit == this.unit && c.name == this.name
                    && c.amount == this.amount && c.decaf == this.decaf ) {
            System.out.println("They are the same in coffee");
                return true;
            }
        System.out.println("They are not the same in coffee");
        return false;

        }


    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
