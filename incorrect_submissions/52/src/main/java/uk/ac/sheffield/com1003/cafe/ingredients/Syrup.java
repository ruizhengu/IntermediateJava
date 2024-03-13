package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this(30,"Caramel");
    }

    public Syrup(String flavour) {
        this(30,flavour);
    }

    public Syrup(int amount){
        this(amount,"Caramel");
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour.toUpperCase();
    }

    /**
     * Checks whether two syrup are the same.
     * @param syrup The syrup to be distinguished.
     * @return True if two syrup are the same amount, unit, name ,flavour,
     * and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Syrup another = (Syrup) obj;

        return this.name.equals(another.getName()) && this.amount == another.getAmount()
             && this.flavour.equals(another.flavour) && this.unit == another.unit;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
