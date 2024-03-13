package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour = "";

    public Syrup(String flavour) {
        this.unit = Unit.ML;
        this.amount = 5;
        this.flavour = flavour;
    }

    public String getFlavour() { return this.flavour; }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Syrup)) {
            return false;
        } else {
            return this.name.equals(((Ingredient) another).getName())
                    && this.unit.equals(((Ingredient) another).getUnit())
                    && this.amount == ((Ingredient) another).getAmount()
                    && this.flavour.equals(((Syrup) another).getFlavour());
        }
    }
}
