package uk.ac.sheffield.com1003.cafe;

import java.util.Arrays;

import javax.swing.SortingFocusTraversalPolicy;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class Recipe {
    public enum Size { SMALL, REGULAR, LARGE };
    private String name;
    private double price;
    private Size size;
    private Ingredient[] ingredients;

    public Recipe(String name, double price) {
        this(name, price, Size.REGULAR, 3);
    }

    public Recipe(String name, double price, Size size, int numberOfIngredients) {
        this.name = name;
        this.price = price;
        this.size = size;
        ingredients = new Ingredient[numberOfIngredients];
    }

    /**
     * Add ingredient to recipe if it does not already exist.
     * If ingredient with the same name already exists, replace it with the new one.
     * @param ingredient Ingredient to be added to recipe.
     * @throws TooManyIngredientsException if the number of ingredients in the recipe would be exceeded
     */
    public void addIngredient(Ingredient ingredient) throws TooManyIngredientsException {
        int i = 0;
        while (i < ingredients.length) {
            if (ingredients[i] == null || ingredients[i].equals(ingredient)) {
                ingredients[i] = ingredient;
                return;
            } else
                i++;
        }
        if (i < ingredients.length)
            ingredients[i] = ingredient;
        else
            throw new TooManyIngredientsException();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Checks whether recipe is ready to be used.
     * @return True if all ingredients of the recipe have been added and false otherwise
     */
    public boolean isReady() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null)
                return false;
        }
        return true;
    }

    public boolean equals(Recipe another){
        if (another == null)
         return false ;
        else if((this.price==another.getPrice())&&(this.size==another.size)&&(this.ingredients.length == another.ingredients.length)){
           
            Ingredient [] w = new Water[1];
            Ingredient [] c = new Coffee[1];
            Ingredient [] m = new Milk[1];

            for(Ingredient ingr : another.ingredients){
                if(ingr.getClass()== Water.class)
                    w[0] = ingr ;
                if(ingr.getClass()== Coffee.class)
                    c[0] = ingr ;
                if(ingr.getClass()== Milk.class)
                    m[0] = ingr ;
            }

            Ingredient [] wa = new Water[1];
            Ingredient [] co = new Coffee[1];
            Ingredient [] mi = new Milk[1];

            for(Ingredient ingr : this.ingredients){
                if(ingr.getClass()== Water.class)
                    wa[0] = ingr ;
                if(ingr.getClass()== Coffee.class)
                    co[0] = ingr ;
                if(ingr.getClass()== Milk.class)
                    mi[0] = ingr ;
            }
            boolean WaterCheck = false;
            boolean CoffeCheck = false;
            boolean MilkCheck = false;

            if((wa[0]!=null)&&(w[0]!=null)){
                if((wa[0].getAmount()== w[0].getAmount()) && (wa[0].getName()==w[0].getName())&&(wa[0].getUnit()==w[0].getUnit())) 
                    WaterCheck = true;}
            else if((wa[0]==null)&&(w[0]==null))
                    WaterCheck = true; 

            if((co[0]!=null)&&(c[0]!=null)){
                if((co[0].getAmount()== c[0].getAmount()) && (co[0].getName()==c[0].getName())&&(co[0].getUnit()==c[0].getUnit())) 
                    CoffeCheck = true;}
            else if((co[0]==null)&&(c[0]==null))
                    CoffeCheck = true; 

            if((mi[0]!=null)&&(m[0]!=null)){        
                if((mi[0].getAmount()== m[0].getAmount()) && (mi[0].getName()==m[0].getName())&&(mi[0].getUnit()==m[0].getUnit())) 
                MilkCheck = true ;}
            else if((mi[0]==null)&&(m[0]==null))
                MilkCheck = true; 

                if((WaterCheck)&&(CoffeCheck)&&(MilkCheck)){
                    System.out.println(this.getName() + " and " + another.getName() +" are equal.");
                    return true ; 
                }else{
                    System.out.println("the values entered are not equal.");
                    return false ;}
            }
         else 
         return false ;
         
    }
}
