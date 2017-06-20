package edu.ncsu.csc216.androtech.model.devices;

/**
 * Thrown whenever information is incorrect for a device
 * 
 * @author Stuart Wells
 * @author Neal Patel
 */
public class BadDeviceInformationException extends Exception {

	/**
	 * constructor for exception
	 */
	public BadDeviceInformationException() {
		super();
	}
	/**
	 * constructor for exception
	 * 
	 * @param message string message
	 */
	public BadDeviceInformationException(String message) {
		super(message);
	}
}
