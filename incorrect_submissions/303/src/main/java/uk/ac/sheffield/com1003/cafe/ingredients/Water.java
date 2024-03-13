package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = Unit.ML ; 
    }

    public Water(int amount){
        this.amount=amount ;
    }

    public Water(int amount, Unit unit){
        this.amount=amount ;
        this.unit=unit ;
    }

    public Water(String name,int amount,Unit unit){
        this.amount=amount ;
        this.name = name;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
