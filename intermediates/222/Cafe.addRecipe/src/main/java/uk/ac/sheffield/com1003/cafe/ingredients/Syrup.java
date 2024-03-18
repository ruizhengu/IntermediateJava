package uk.ac.sheffield.com1003.cafe.ingredients;

/**Syrup is a type of Ingredient
 * An instance on syrup can be used in a recipe
 * @author Antoni Nikolak
 */

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(){
        this("strawberry");
    }

    public Syrup(String flavour) {
        this(flavour, 20);

    }

    public Syrup(String flavour, int amount) {
        this.unit = Unit.ML;
        this.flavour = flavour;
        this.amount = amount;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Syrup syrup = (Syrup) o;
        return name.equals(syrup.name) && flavour.equals(syrup.flavour) && amount == syrup.getAmount() && unit == syrup.getUnit();
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

}
