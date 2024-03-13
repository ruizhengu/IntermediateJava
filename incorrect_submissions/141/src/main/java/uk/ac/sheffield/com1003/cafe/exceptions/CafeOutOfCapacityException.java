package uk.ac.sheffield.com1003.cafe.exceptions;

//basic exception which gets the capacity of a cafe instance passed in
//this capacity int is used to inform the user of the maximum capacity which they exceeded

public class CafeOutOfCapacityException extends Exception{
	
	int capacity;
	
	public CafeOutOfCapacityException(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public String getMessage() {
		return "Cafe at order capacity(" + this.getCapacity() + ")";
	}
}
