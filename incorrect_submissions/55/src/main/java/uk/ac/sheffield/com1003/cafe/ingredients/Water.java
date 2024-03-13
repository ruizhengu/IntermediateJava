package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }
    
    //overloading existing water constructor for task 1.2
    public Water(int amount) {
    	this.amount = 50 ;
    }
    

  //updating constructor water according to task 1.1
    public Water(String name, Unit unit, int amount) {
    	this.name="Water";
    	this.unit=Unit.ML;
    	this.amount=amount;
	}

	@Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
