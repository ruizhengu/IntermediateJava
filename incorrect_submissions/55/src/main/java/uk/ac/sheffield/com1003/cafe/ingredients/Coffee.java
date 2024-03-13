package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }
    
    //overload existing coffee constructor for task 1.2
    public Coffee(int amount) {
    	this.amount = 15 ;
    }
    

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf; 
    }
    

    //Task 1
    public Coffee(String name, Unit unit, int amount) {
    	this.name= "Coffee";
    	this.unit= Unit.GR;
    	this.amount= amount;
    	this.decaf= false;
	}

	@Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
