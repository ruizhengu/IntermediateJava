package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Order;


public class CafeOutOfCapacityException extends Exception {
	public CafeOutOfCapacityException(String message) {
		super(message);
	}
}
