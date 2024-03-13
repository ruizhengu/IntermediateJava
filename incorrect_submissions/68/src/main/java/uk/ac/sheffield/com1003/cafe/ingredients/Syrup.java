package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 *The Syrup ingredient class that can be part of a recipe.
 *
 * Last Edited by Jakub Bala, 16/03/2023
 */
public class Syrup extends Ingredient{

    private String flavour;

    /**
     * Default Constructor
     */
    public Syrup(){
        this(30, "Strawberry");
    }

    /**
     * Amount only overload
     * @param amount
     */
    public Syrup(int amount){
        this(amount, "Strawberry");
    }

    /**
     * Fully definable constructor
     * @param amount
     * @param flavour
     */
    public Syrup(int amount, String flavour){
        this.name = "Syrup";
        this.amount = amount;
        this.flavour = flavour;
        this.unit = Unit.ML;
    }

    public String getFlavour(){
        return flavour;
    }

    @Override
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * Checks whether a passed in object is an ingredient of the same
     * type, and has the same instance variable values
     * @param other The object being compared with
     * @return Returns true if the passed in ingredient matches this instance
     */
    @Override
    public boolean equals(Object other){

        if (!(other instanceof Syrup)){
            return false;
        }

        System.out.println("same type");

        Syrup otherSyrup = ((Syrup)other);

        if(!name.equals(otherSyrup.getName())){
            return false;
        }

        System.out.println("same name");

        if(!unit.equals(otherSyrup.getUnit())){
            return false;
        }
        System.out.println("same unit");
        if(amount != otherSyrup.getAmount()){
            return false;
        }
        System.out.println("same amount");
        if(!flavour.equals(otherSyrup.getFlavour())){
            return false;
        }
        System.out.println("same favlour");

        return true;
    }
}
