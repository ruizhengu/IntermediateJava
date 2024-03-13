package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {

    //task 3
        @Override
        public String getMessage() {
            return super.getMessage() + "Cafe out of Capacity" ;
        }

}
