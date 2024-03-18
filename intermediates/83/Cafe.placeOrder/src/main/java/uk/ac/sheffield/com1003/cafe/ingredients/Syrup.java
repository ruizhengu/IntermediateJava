package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	private String flavour;

	public Syrup() {
		this(Unit.ML, 50, "Maple");
	}

	public Syrup(Unit unit, int amount, String flavour) {
		this.name = "Syrup";
		this.unit = unit;
		this.amount = amount;
		this.flavour = flavour;
	}

	@Override
	public String toString() {
		// Syrup [unit=<unit>, amount=<amount>, flavour=<flavour>]
		return "Syrup [unit="+unit + (", amount="+amount) + (", flavour="+flavour) + "]";
	}

	@Override
	public boolean equals(Object another) {
		if (another == null || !(another instanceof Syrup))
			return false;

		Syrup otherSyrup = (Syrup) another;
		return super.equals(otherSyrup) &&
			unit == otherSyrup.unit &&
			amount == otherSyrup.amount &&
			flavour == otherSyrup.flavour;
	}
}
