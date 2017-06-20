package edu.ncsu.csc216.androtech.model.repair_center;

/**
 * DroidBusyException class
 * 
 * @author Stuart Wells
 * @author Neal Patel
 *
 */

public class DroidBusyException extends Exception{

	/**
	 * Exception constructor
	 */
	public DroidBusyException(){
	    super();
	}

	
	/**
	 * Exception constructor with message
	 * 
	 * @param message takes a String
	 */
	public DroidBusyException(String message){
	    super(message);
	}
	
}
