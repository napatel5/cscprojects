package edu.ncsu.csc216.androtech.model.repair_center;
import edu.ncsu.csc216.androtech.model.devices.Device;

/**
 * TechDroid abstract class
 * 
 * @author Stuart Wells
 * @author Neal Patel
 *
 */

public abstract class TechDroid {
	
	private boolean assigned;
	
	private String droidID;
	
	private static int nextNumber;
	
	private Device myDevice;
	
	/**
	 * Restarts TechDroid numbering
	 */
	public static void startDroidNumberingAt01(){
		nextNumber = 1;
	}
	
	/**
	 * Constructor for TechDroid
	 * @param droidID from subclass
	 */
	public TechDroid(String droidID){
		if (nextNumber < 10) {
			this.droidID = "0" + nextNumber + droidID;
		} else {
			this.droidID = nextNumber + droidID;
		}
		nextNumber += 1;
	}
	
	/**
	 * Getter
	 * @return droidID
	 */
	public String getDroidID(){
		return droidID;
	}
	
	/**
	 * Getter
	 * @return assigned
	 */
	public boolean isAssigned(){
		return assigned;
	}
	
	/**
	 * Releases droid and returns Device that was worked on
	 * @return tempDevice;
	 */
	public Device release(){
		assigned = false;
		Device tempDevice = myDevice;
		myDevice = null;
		
		return tempDevice;
	}
	
	/**
	 * Assigns the Device to the TechDroid
	 * @param toAssign is the device to be assigned
	 * @throws DroidDeviceMismatchException
	 * @throws DroidBusyException
	 */
	public void assign(Device toAssign) throws DroidDeviceMismatchException, DroidBusyException{
		if(assigned){
			throw new DroidBusyException();
		}
		assigned = true;
		myDevice = toAssign;
	}
	
	/**
	 * Makes a printable version of the TechDroid's information
	 * @return String version of the TechDroid's information
	 */
	public String toString(){
		String output;
		if(assigned){
			output = String.format("%s: %-7s %s", droidID, myDevice.getSerialNum(), myDevice.getName());
		} else {
			output = String.format("%s: %-7s", droidID, "UNASSIGNED");
		}
		return output;
	}
	
}
