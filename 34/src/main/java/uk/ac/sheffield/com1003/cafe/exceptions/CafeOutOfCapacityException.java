package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
	
	public void errorMessage() {
		System.out.println("The capacity for this cafe has been exceeded");
	}

}
