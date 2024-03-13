package uk.ac.sheffield.com1003.cafe.exceptions;

@SuppressWarnings("serial")
public class CafeOutOfCapacityException extends Exception{
	int maxOrderNumber;
	
	public CafeOutOfCapacityException(int maxOrderNumber) {
		this.maxOrderNumber = maxOrderNumber;
	}
	
	public int getMaxOrderNumber() {
		return maxOrderNumber;
	}
}
