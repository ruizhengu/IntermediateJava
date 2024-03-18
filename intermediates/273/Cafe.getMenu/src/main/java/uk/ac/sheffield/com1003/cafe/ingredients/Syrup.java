package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    //Task 6
    private String flavour;

    public Syrup(){
        this.amount = 10;
        this.unit = Unit.ML;
        this.flavour = "Vanilla";
    }

    public Syrup(String flavour) { this.flavour = flavour;}

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object o){
        if (o == null || ! (o instanceof Syrup))
            return false;
        if (! this.name.equals(((Syrup)o).getName())){
            return false;
        }
        if (! this.unit.equals(((Syrup)o).getUnit())){
            return false;
        }
        if (! this.flavour.equals(((Syrup)o).getFlavour())){
            return false;
        }
        if (this.amount != ((Syrup)o).getAmount()){
            return false;
        }

        return true;
    }

    private String getFlavour() {
        return flavour;
    }
}
