package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
    //provides an error string that can be outputted
    private String errorString;

    public CafeOutOfCapacityException(String context) {
        //context in which exception was thrown changes the error string
        if (context == "Serving")
            this.errorString = ("All orders up to capacity have been served");
        else if (context == "Ordering")
            this.errorString = ("Cafe order capacity reached");
        else
            this.errorString = ("Order capacity was reached for unknown reason - cafe may have 0 order capacity");
    }
    public String getErrorString() {
        return errorString;
    }
}
