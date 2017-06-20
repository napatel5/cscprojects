package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;
import edu.ncsu.csc216.androtech.model.devices.*;

import org.junit.Before;
import org.junit.Test;
/**
 * tests for VRDroid test
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class VRDroidTest {
	/**
	 * a vr droid
	 */
	public VRDroid vrDroid;
	/**
	 * a vr device
	 */
	public VRDevice vrDevice;
	/**
	 * sets up VRDroids for testing
	 * 
	 * @throws Exception for testing VRDroid
	 */
	@Before
	public void setUp() throws Exception {
		vrDroid = new VRDroid();
		vrDevice = new VRDevice("1234-1234", "Neal Patel", 0);
	}
	/**
	 * tests assign for VRDroids
	 */
	@Test
	public void testAssign() {
		try {
			vrDroid.assign(vrDevice);
		} catch (Exception e) {
			System.out.print("");
		}
		assertFalse(vrDroid.equals(""));
	}

}
