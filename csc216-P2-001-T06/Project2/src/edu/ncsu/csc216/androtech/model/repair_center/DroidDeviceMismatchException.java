package edu.ncsu.csc216.androtech.model.repair_center;

/**
 * DroidDeviceMistmatchException class
 * 
 * @author Stuart Wells
 * @author Neal Patel
 *
 */

public class DroidDeviceMismatchException extends Exception{
	
	/**
	 * Exception constructor
	 */
	public DroidDeviceMismatchException(){
	    super();
	}

	/**
	 * Exception constructor with message
	 * 
	 * @param message takes a String
	 */
	public DroidDeviceMismatchException(String message){
	    super(message);
	}

}
