package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 18;
        this.flavour = "mint";
    }

    public Syrup(int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = "mint";
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object syrup) {
        if (syrup instanceof Syrup) {
            Syrup anotherSyrup = (Syrup) syrup;
            if (this.name == anotherSyrup.name &&this.amount == anotherSyrup.amount && this.unit == anotherSyrup.unit
            && this.flavour == anotherSyrup.flavour)
                return true;
            else return false;
        }else return false;
    }
}
