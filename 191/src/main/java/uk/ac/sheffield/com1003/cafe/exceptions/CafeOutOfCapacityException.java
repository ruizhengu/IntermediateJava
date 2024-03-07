package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
	//instance variable
	private int noCapacity;
	
	//constructor
	public CafeOutOfCapacityException(int noCapacity) {
		this.noCapacity= noCapacity;
	}
	
	//accessor method
	public int getNoCapacity() {
		return noCapacity;
	}

}
