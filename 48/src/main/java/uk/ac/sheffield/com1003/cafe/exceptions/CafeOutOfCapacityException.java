package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
    
    private String s;
    
    public CafeOutOfCapacityException(String s){
        this.s = s;
    }

    public String getString(){
        return s;
    }
}
