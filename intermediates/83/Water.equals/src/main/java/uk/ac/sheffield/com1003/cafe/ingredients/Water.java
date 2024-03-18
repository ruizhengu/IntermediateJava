package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

	public Water(int amount) {
		this.name = "Water";
		this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

	@Override
	public boolean equals(Object another) {
		if (another == null || !(another instanceof Water))
			return false;
			
		Water otherWater = (Water) another;
		return super.equals(another) &&
			unit == otherWater.unit &&
			amount == otherWater.amount;
	}
}
