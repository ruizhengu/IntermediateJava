package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }

    public Water(int amount){
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object o){
        if (o == null || ! (o instanceof Water))
            return false;
        if (! this.name.equals(((Water)o).getName())){
            return false;
        }
        if (! this.unit.equals(((Water)o).getUnit())){
            return false;
        }
        if (this.amount != ((Water)o).getAmount()){
            return false;
        }

        return true;
    }
}
