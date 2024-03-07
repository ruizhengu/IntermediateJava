package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavor;

    public Syrup(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Syrup{" +
                "flavor='" + flavor + '\'' +
                ", unit=" + unit +
                ", amount=" + amount +
                '}';
    }
}
