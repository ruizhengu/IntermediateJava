package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public String getFlavour() {return this.flavour; }

    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = unit.ML;
        this.amount = 15;
    }

    public Syrup() {
        this.flavour = "Maple";
        this.unit = unit.ML;
        this.amount = 15;
    }
//equals method for syrup
    public boolean equals(Object syrup) {
        if (syrup == this) {
            return true;
        }

        if (! (syrup.getClass() == this.getClass()) ) {
            return false;
        }

        Syrup s = (Syrup) syrup;

        if (s.unit == this.unit && s.amount == this.amount && s.flavour == this.flavour ) {
            System.out.println("They are the same in syrup");
            return true;
        }
        System.out.println("They are not the same in syrup");
        return false;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

}

