package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof Syrup) {
            Syrup otherSyrup = (Syrup) another;
            if (name.equals(otherSyrup.getName()) && unit.equals((otherSyrup.getUnit())) && amount == otherSyrup.getAmount()
                    && flavour == otherSyrup.flavour) {
                return true;
            }
            return false;
        }
        return false;
    }
}
