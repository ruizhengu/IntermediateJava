package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    private int maxCapacity;
    public CafeOutOfCapacityException(int cafeCapacity){
        this.maxCapacity = cafeCapacity;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
}
