package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    public enum Flavour { CHOCOLATE, STRAWBERRY, VANILLA };
    private Flavour flavour;

    public Syrup() {
        this.unit = Unit.ML;
        this.flavour = Flavour.VANILLA;
    }

    public Syrup(Flavour flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object syrup) {
        if (syrup == this) {
            return true;
        }

        if (!(syrup instanceof Syrup)) {
            return false;
        }

        Syrup nSyrup = (Syrup) syrup;
        if (this.name.equals(nSyrup.name) && 
        this.unit == nSyrup.unit &&
        this.amount == nSyrup.amount &&
        this.flavour == nSyrup.flavour) {
            return true;
        } else {
            return false;
        }
    }
}
