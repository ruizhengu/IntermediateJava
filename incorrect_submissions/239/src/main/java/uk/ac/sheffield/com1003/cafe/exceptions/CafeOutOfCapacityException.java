package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
	
	private int i;
	
	public CafeOutOfCapacityException(int i) {
		this.i = i;
	}


}
