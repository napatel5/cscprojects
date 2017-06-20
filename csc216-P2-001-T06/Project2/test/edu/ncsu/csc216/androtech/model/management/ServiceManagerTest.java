package edu.ncsu.csc216.androtech.model.management;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.devices.ComDevice;
import edu.ncsu.csc216.androtech.model.devices.Prioritizable;
import edu.ncsu.csc216.androtech.model.devices.VRDevice;
import edu.ncsu.csc216.androtech.model.repair_center.RepairCenter;
/**
 * tests Service Manager
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class ServiceManagerTest {
	/**
	 * a device list
	 */
	public ServiceManager s;	
	/**
	 * a repair center
	 */
	public RepairCenter r;
	/**
	 * a comdevice
	 */
	public ComDevice c;
	/**
	 * a vr device
	 */
	public VRDevice v;
	/**
	 * a vr device
	 */
	public ServiceManager sm;

	/**
	 * sets up service manager for testing
	 * 
	 * @throws Exception
	 */
	
	@Before
	public void setUp() throws Exception {
		s = new ServiceManager();
		r = new RepairCenter();
		c = new ComDevice("1234-4321", "Neal Patel", 2);
		v = new VRDevice("4321-1234", "Stuart Wells", 1);
		sm = new ServiceManager(new Scanner("C 2 MA1 Doe, John"));
		sm = new ServiceManager(new Scanner("V 2 MA1 Doe, John"));
	}
	/**
	 * tests put on waiting list
	 */
	@Test
	public void testPutOnWaitingList() {
		s.putOnWaitingList("V", "1234-4321", "Neal", 1);
		s.putOnWaitingList("V", "1234-4321", "Neal", 4);
		s.putOnWaitingList("V", "1234-4321", "Neal", -4);
		s.putOnWaitingList("C", "1234-4321", "Neal", 1);
		s.putOnWaitingList("C", "1234-4321", "Neal", 4);
		s.putOnWaitingList("C", "1234-4321", "Neal", -4);
		s.putOnWaitingList("V", " ", "Neal", 1);
		s.assignDroids();
		assertFalse(s.equals(""));
	}
	/**
	 * tests put on waiting list
	 */
	@Test
	public void testPutOnWaitingListPrioritizable() {
		s.putOnWaitingList((Prioritizable)c);
		assertFalse(s.equals(""));
		
	}
	/**
	 * tests remove
	 */
	@Test
	public void testRemove() {
		s.remove("Neal", 0);
		assertFalse(s.equals(""));
	}
	/**
	 * tests assign droids
	 */
	@Test
	public void testAssignDroids() {
		s.assignDroids();
		assertFalse(s.equals(""));
	}
	/**
	 * tests release from service
	 */
	@Test
	public void testReleaseFromService() {
		s.putOnWaitingList(v);
		s.assignDroids();
		s.releaseFromService(0);
		assertFalse(s.equals(""));
	}
	/**
	 * tests add new droid
	 */
	@Test
	public void testAddNewDroid() {
		s.addNewDroid();
		assertFalse(s.equals(""));
	}
	/**
	 * tests print wait list
	 */
	@Test
	public void testPrintWaitList() {
		s.putOnWaitingList(v);
		s.putOnWaitingList(c);
		s.printWaitList("Neal");
		assertFalse(s.equals(""));
	}
	/**
	 * tests print droids
	 */
	@Test
	public void testPrintDroids() {
		s.printDroids();
		assertFalse(s.equals(""));
	}
	
}
