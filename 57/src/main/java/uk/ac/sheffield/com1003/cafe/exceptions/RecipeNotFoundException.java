package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    public String s;

    public RecipeNotFoundException (String s){
        this.s = s;
    }

    public String getString(){
        return s;
    }
}