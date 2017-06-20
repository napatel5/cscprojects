package edu.ncsu.csc216.androtech.model.repair_center;

import edu.ncsu.csc216.androtech.model.devices.Device;

/**
 * ComDroid is a TechDroid that works on ComDevices 
 * 
 * @author Stuart Wells
 * @author Neal Patel
 *
 */

public class ComDroid extends TechDroid {

	/**
	 * Constructor class
	 */
	public ComDroid() {
		super("C");
	}
	
	/**
	 * Checks that the device can be assigned to this type of droid and assigns it.
	 * @param toAssign Device to assign
	 * @throws DroidDeviceMismatchException
	 * @throws DroidBusyException
	 */
	public void assign(Device toAssign) throws DroidDeviceMismatchException, DroidBusyException{
		if (toAssign.toString().charAt(0) == 'V') {
			throw new DroidDeviceMismatchException();
		} else {
			super.assign(toAssign);
		}
	}
	
}
