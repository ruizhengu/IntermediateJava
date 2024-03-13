package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
		// Milk [unit=<unit>, amount=<amount>, type=<type>]
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

	@Override
	public boolean equals(Object another) {
		if (another == null || !(another instanceof Milk))
			return false;

		Milk otherMilk = (Milk) another;
		return super.equals(otherMilk) &&
			unit == otherMilk.unit &&
			amount == otherMilk.amount &&
			type == otherMilk.type;
	}
}
