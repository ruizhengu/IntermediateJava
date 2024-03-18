package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Caramel",10);
    }
    public Syrup(String flavour, int amount){
        this.name = flavour + "syrup";
        this.flavour = flavour;
        this.unit = Unit.GR;
        this.amount = amount;
    }


    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String toString() {
        return "Syrup [unit= " + "{ " + getUnit() + " }" +
                ", amount= " + "{ " + getAmount() + " }" + ", flavour= " + "{ " + flavour + " }" + "]";
    }
}
