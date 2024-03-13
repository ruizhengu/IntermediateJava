package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
	
	private int indexOfCurrentItem;
	private int maxNumOfItems;
	
	/**
     * Constructor which takes a index which is out of bounds
     * and the maximum index of the array where error occurred
     */
	public CafeOutOfCapacityException(int indexOfCurrentItem, int maxNumOfItems)	{
		this.indexOfCurrentItem = indexOfCurrentItem;
		this.maxNumOfItems = maxNumOfItems;
	}
	
    /**
     * Getter for out of bound index
     * @return the out of bound index
     */
	public int getIndexOfCurrentItem()	{
		return indexOfCurrentItem;
	}
	
	 /**
     * Getter for the max index possible
     * @return the maximum possible index
     */
	public int getMaxNumOfItems() 	{
		return maxNumOfItems;
	}
}
