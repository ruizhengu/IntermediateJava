package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * A class representing milk as an ingredient.
 *
 * Milk is an Ingredient with a specific type, such as whole, semi-skimmed, skimmed, or soy.
 */
public class Milk extends Ingredient {

  public enum Type {
    WHOLE,
    SEMI,
    SKIMMED,
    SOY,
  }

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

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
  }
}
