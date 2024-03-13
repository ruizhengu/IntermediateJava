package uk.ac.sheffield.com1003.cafe.ingredients;

public class CocoaPowder extends Ingredient {

    public CocoaPowder() {
        this.amount = 5;
    }

    public CocoaPowder(int amount) {
        this.name = "Cocoa Powder";
        this.amount = amount;
        this.unit = Unit.GR;
    }

    @Override
    public String toString() {
        return "Cocoa Powder [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object o){
        if (o == null || ! (o instanceof CocoaPowder))
            return false;
        if (! this.name.equals(((CocoaPowder)o).getName())){
            return false;
        }
        if (! this.unit.equals(((CocoaPowder)o).getUnit())){
            return false;
        }
        if (this.amount != ((CocoaPowder)o).getAmount()){
            return false;
        }

        return true;
    }

}
