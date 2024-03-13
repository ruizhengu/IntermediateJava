package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
        this.name = "Coffee";
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public Coffee(int i) {
		this.amount = i; 
		this.unit = Unit.GR;
        this.decaf = false;
        this.name = "Coffee";
	}

	@Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
