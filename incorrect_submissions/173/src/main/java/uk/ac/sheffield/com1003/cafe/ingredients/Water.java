package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water"; 
        this.unit = Unit.ML; 
    }

    public Water(int i) {
		this.amount = i; 
		this.name = "Water"; 
        this.unit = Unit.ML; 
	}

	@Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
