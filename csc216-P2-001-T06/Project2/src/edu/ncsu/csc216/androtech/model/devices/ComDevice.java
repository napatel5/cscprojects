/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

/**
 * ComDevice is a subclass of Device
 * 
 * @author Stuart Wells
 * @author Neal Patel
 */
public class ComDevice extends Device {
	/**
	 * constructor for Comdevice
	 * 
	 * @param customer string name of the customer
	 * @param serialNumber string serial number of the device
	 * @param tier int of the tier the customer has
	 * @throws BadDeviceInformationException exception for incorrect device information
	 */
	public ComDevice(String serialNumber, String customer, int tier) throws BadDeviceInformationException{
		super(serialNumber, customer, tier);
	}
	/**
	 * prints device information
	 * 
	 * @return String a string of the device information
	 */
	public String toString() {
		String output;
		//if(this.getTier() == 0){
		output = String.format("C %-9s %s %s", CUSTOMER_TIER[this.getTier()], this.getSerialNum().trim(), this.getName().trim());
		/*
		}else if(this.getTier() == 1){
			output = String.format("C %s-8d %s %s", "Silver", this.getSerialNum(), this.getName());
		}else if(this.getTier() == 2){
			output = String.format("C %s-8d %s %s", "Gold", this.getSerialNum(), this.getName());
		}else{
			output = String.format("C %s-8d %s %s", "Platinum", this.getSerialNum(), this.getName());
		}
		*/
		return output;
	}
	
}
