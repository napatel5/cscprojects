/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

/**
 * VRDevice subclass of device
 * 
 * @author Stuart Wells
 * @author Neal Patel
 */
public class VRDevice extends Device {
	/**
	 * constructor for VRDevice
	 * 
	 * @param customer string of the customer's name
	 * @param serialNumber string of the serial number
	 * @param tier int of the tier
	 * @throws BadDeviceInformationException thrown when device information is incorrect
	 */
	public VRDevice(String serialNumber, String customer, int tier) throws BadDeviceInformationException{
		super(serialNumber, customer, tier);
	}
	/**
	 * converts VRDevice information to a string
	 * 
	 * @return String of the VRDevice information
	 */
	public String toString() {
		String output;
		output = String.format("V %-9s %s %s", CUSTOMER_TIER[this.getTier()], this.getSerialNum().trim(), this.getName().trim());
		return output;
	}
}
