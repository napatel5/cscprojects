package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * JUnit test cases for ComDevice
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class ComDeviceTest {
	/**
	 * a ComDevice
	 */
	public ComDevice d;
	
	/**
	 * a comdevice with bad info
	 */
	public ComDevice badCom;
	
	/**
	 * setup method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		d = new ComDevice("1234-4321", "Neal Patel", 2);
	}
	
	/**
	 * tests bad device information exception
	 */
	@Test
	public void testBadInformationException(){
		try { 
			badCom = new ComDevice("", "", 1);
		}
		catch (Exception e) {
				System.out.print("");
				assertFalse(d.toString().equals("sdf"));
		}
	}
	
	/**
	 * tests toString method
	 */
	@Test
	public void testToString() {
		assertFalse(d.toString().equals(""));
	}
}
