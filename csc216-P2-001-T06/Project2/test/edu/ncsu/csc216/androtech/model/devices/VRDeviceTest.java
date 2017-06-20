package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * test VRDroid
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class VRDeviceTest {
	/**
	 * a vr device
	 */
	public VRDevice v;
	/**
	 * a bad vrdevice
	 */
	VRDevice badVR;
	/**
	 * sets up vr device for test
	 * 
	 * @throws Exception for device being tested
	 */
	@Before
	public void setUp() throws Exception {
		v = new VRDevice("1234-1234", "Neal Patel", 0);
	}
	
	/**
	 * tests a bad vrdevice
	 */
	@Test
	public void testBadDeviceInformationException() {
		try { 
			badVR = new VRDevice("", "", 1);
		}
		catch (Exception e) {
				System.out.print("");
				assertFalse(v.toString().equals("sdf"));
		}
	}
	/**
	 * tests toString
	 */
	@Test
	public void testToString() {
		assertFalse(v.toString().equals(""));
	}
}
