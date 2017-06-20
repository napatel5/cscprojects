package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * JUnit test for DeviceTest
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class DeviceTest {
	
	/**
	 * a com device
	 */
	public ComDevice c;
	
	/**
	 * a vr device
	 */
	public VRDevice v;
	
	/**
	 * a bad vr device
	 */
	public VRDevice badVR;
	
	/**
	 * sets up devices for testing
	 * 
	 * @throws Exception for devices to be tested
	 */
	@Before
	public void setUp() throws Exception {
		c = new ComDevice("1234-4321", "Neal Patel", 2);
		v = new VRDevice("4321-1234", "Stuart Wells", 1);
	}
	
	/**
	 * 
	 */
	
	/**
	 * tests meetsFilter
	 */
	@Test
	public void testMeetsFilter() {
		assertTrue(c.meetsFilter("Neal"));
	}
	/**
	 * tests toString
	 */
	@Test
	public void testToString() {
		assertFalse(v.toString().equals(""));		
	}
	/**
	 * tests getName
	 */
	@Test
	public void testGetName() {
		assertTrue(c.getName().equals("Neal Patel"));
	}
	/**
	 * tests getSerialNum
	 */
	@Test
	public void testGetSerialNum() {
		assertTrue(v.getSerialNum().equals("4321-1234"));
	}
	/**
	 * tests getTier
	 */
	@Test
	public void testGetTier() {
		int b = 2;
		assertEquals(c.getTier(), b);
	}
	/**
	 * tests compareToTier
	 */
	@Test
	public void testCompareToTier() {
		assertEquals(v.compareToTier(c), -1);
	}
}
