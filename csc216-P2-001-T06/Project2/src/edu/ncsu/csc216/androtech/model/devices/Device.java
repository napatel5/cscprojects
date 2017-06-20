
/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

/**
 * Abstract class for devices
 * 
 * @author Stuart Wells
 * @author Neal Patel
 */
public abstract class Device implements Prioritizable {
	/**
	 * string of the serial number
	 */
	private String serialNum;
	/**
	 * string of the customer's name
	 */
	private String name;
	/**
	 * int of the customer's tier
	 */
	private int tierIndex;
	/**
	 * array of tier types
	 */
	public static final String[] CUSTOMER_TIER = {"None", "Silver", "Gold", "Platinum"};
	/**
	 * constructor for Device
	 * 
	 * @param customer string name of the customer
	 * @param serialNumber string of serial number
	 * @param tier int of the tier
	 * @throws BadDeviceInformationException exception thrown for incorrect device information
	 */
	public Device(String serialNumber, String customer, int tier) throws BadDeviceInformationException{
		if(customer != null){
			this.name = customer.trim();
			this.validateName();
		} else {
			this.name = customer;
			throw new BadDeviceInformationException("Owner name cannot be blank.");
		}
		if(serialNumber != null){
			this.serialNum = serialNumber.trim();
			this.validateSerialNum();
		} else {
			this.serialNum = serialNumber;
			throw new BadDeviceInformationException("Serial number cannot be blank.");
		}
		if(tier > 3){
			this.tierIndex = 3;
		} else if(tier < 0) {
			this.tierIndex = 0;
		} else {
			this.tierIndex = tier;
		}
	}
	/**
	 * checks to see if the device meets the filter string
	 * 
	 * @param filter string of the filter
	 * @return boolean if the device matches the filter
	 */
	public boolean meetsFilter(String filter) {
		if(this.name.toUpperCase().startsWith(filter.toUpperCase())){
			return true;
		}
		return false;
	}
	/**
	 * converts to string
	 * 
	 * @return String
	 */
	public String toString() {
		return "";
	}
	/**
	 * gets the name of the customer
	 * 
	 * @return String name of the customer
	 */
	public String getName() {
		return name;
	}
	/**
	 * gets serial number
	 * 
	 * @return String of the serial number
	 */
	public String getSerialNum() {
		return serialNum;
	}
	/**
	 * gets the tier index
	 * 
	 * @return int tier index
	 */
	public int getTier() {
		return tierIndex;
	}
	/**
	 * compares tier of device with another
	 * 
	 * @param pr a prioritizable
	 * @return int of the tier
	 */
	public int compareToTier(Prioritizable pr) {
		
		if (pr.getTier() == this.tierIndex) {
			return 0;
		}
		else if (pr.getTier() > this.tierIndex) {
			return -1;
		}
		else return 1;
	}
	
	
	private void validateName() throws BadDeviceInformationException{
		if (this.name.trim().length() <= 0){
			throw new BadDeviceInformationException("Owner name cannot be blank.");
		}
	}
	
	private void validateSerialNum() throws BadDeviceInformationException{
		if (this.serialNum.trim().length() <= 0){
			throw new BadDeviceInformationException("Serial number cannot be blank.");
		}
	}
}
