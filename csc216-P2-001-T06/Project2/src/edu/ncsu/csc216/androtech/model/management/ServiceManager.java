/**
 * 
 */
package edu.ncsu.csc216.androtech.model.management;

import edu.ncsu.csc216.androtech.model.devices.*;
import edu.ncsu.csc216.androtech.model.repair_center.*;
import edu.ncsu.csc216.androtech.model.util.SimpleIterator;

import java.util.*;

/**
 * Class to manage devices and droids
 * 
 * @author Stuart Wells
 * @author Neal Patel
 *
 */
public class ServiceManager implements Manager {
	
	private DeviceList devicesWaiting;
	
	private RepairCenter androTech;

	
	/**
	 * Constructor for the class
	 */
	public ServiceManager() {
		devicesWaiting = new DeviceList();
		androTech = new RepairCenter();
	}
	
	/**
	 * Constructor that takes a file name for the class
	 * @param s file for devices
	 */
	public ServiceManager(Scanner s) {
		devicesWaiting = new DeviceList(s);
		androTech = new RepairCenter();
	}
	
	private void findDroid(Device d) {
		if (d.toString().charAt(0) == 'V') {
			for (int i = 0; i < androTech.totalNumberOfDroids() - 1; i++) {
				boolean b = androTech.getDroidAt(i).isAssigned();
				if (!b) {
					try{
						androTech.getDroidAt(i).assign(d);
						devicesWaiting.remove(d.getName(), 1);
					} catch(Exception e) {
						System.out.print("");
					}
					break;
				}
			}
		}
		
		if (d.toString().charAt(0) == 'C') {
			for (int i = androTech.totalNumberOfDroids() - 1; i > 0; i--) {
				boolean b = androTech.getDroidAt(i).isAssigned();
				if (!b) {
					try{
						androTech.getDroidAt(i).assign(d);
						devicesWaiting.remove(d.getName(), 1);
					} catch(Exception e) {
						System.out.print("");
					}
					break;
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#putOnWaitingList(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	
	/**
	 * Places a device on the waiting list
	 * @param k type
	 * @param b serial
	 * @param c name
	 * @param x tier
	 */
	public void putOnWaitingList(String k, String b, String c, int x) {
		try{
			Prioritizable com = null;
			if (k.toUpperCase().equals("C")) {
				if(x > 3) {
					com = new ComDevice(c, b, 3);
				} else if(x < 0) {
					com = new ComDevice(c, b, 0);
				} else {
					com = new ComDevice(c, b, x);
				}
			} else if (k.toUpperCase().equals("V")) {
				if(x > 3) {
					com = new VRDevice(c, b, 3);
				} else if(x < 0) {
					com = new VRDevice(c, b, 0);
				} else {
					com = new VRDevice(c, b, x);
				}
			}
			devicesWaiting.add((Device)com);
		} catch(Exception e) {
			System.out.print("");
		}
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#putOnWaitingList(edu.ncsu.csc216.androtech.model.devices.Prioritizable)
	 */
	
	/**
	 * adds a device to the waiting list
	 * @param v Device to put on list
	 */
	public void putOnWaitingList(Prioritizable v) {
		devicesWaiting.add((Device) v);
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#remove(java.lang.String, int)
	 */
	
	/**
	 * Removes a device from the list
	 * @return Prioritizable Device to be returned
	 * @param filter String to math device's owner's name
	 * @param position int of the position of device in filtered list
	 */
	public Prioritizable remove(String filter, int position) {
		return devicesWaiting.remove(filter, position);
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#assignDroids()
	 */
	/**
	 * Calls findDroid for each available droid
	 */
	public void assignDroids() {
		SimpleIterator<Device> iterator = devicesWaiting.iterator();
		if(iterator.hasNext()){
			while (iterator.hasNext()) {
				findDroid(iterator.next());
			}
			findDroid(iterator.next());
		}
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#releaseFromService(int)
	 */
	/**
	 * Releases a device from a droid
	 * @return Prioritizable Device to be returned
	 * @param droid index of droid to release device
	 */
	public Prioritizable releaseFromService(int droid) {
		return androTech.release(droid);
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#addNewDroid()
	 */
	
	/**
	 * Adds a new TechDroid
	 */
	public void addNewDroid() {
		androTech.addTechDroid();
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#printWaitList(java.lang.String)
	 */
	
	/**
	 * Prints the waitlist
	 * @return String of the waitlist
	 * @param filter String to filter list
	 */
	public String printWaitList(String filter) {
		return devicesWaiting.filteredList(filter);
	}

	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.androtech.model.management.Manager#printDroids()
	 */
	
	/**
	 * Returns a string of all droids
	 * @return String list of droids
	 */
	public String printDroids() {
		return androTech.printDroids();
	}

}
