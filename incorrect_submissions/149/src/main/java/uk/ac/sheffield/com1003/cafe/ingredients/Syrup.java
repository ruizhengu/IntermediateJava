package uk.ac.sheffield.com1003.cafe.ingredients;
public class Syrup extends Ingredient {
    private String flavour;
/*This is task 6*/
/*This task required us to create a private class named flavour*/
/*Task 6 also asks us to overide the Sting()*method and return a format Syrup[unit={},amount ={}, flavour={}]*/
    public Syrup(String flavour) {
        super("Syrup", Unit.GR);
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}