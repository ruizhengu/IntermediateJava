package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Cafe;

public class CafeOutOfCapacityException extends Exception{
	private Cafe cafe;
	
	public CafeOutOfCapacityException(Cafe cafe) {
		this.cafe = cafe;
	}
	
	public Cafe getCafe() {
		return cafe;
	}
}
