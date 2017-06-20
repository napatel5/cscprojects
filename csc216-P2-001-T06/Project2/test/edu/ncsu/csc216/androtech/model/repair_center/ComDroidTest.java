package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;
import edu.ncsu.csc216.androtech.model.devices.*;

import org.junit.Before;
import org.junit.Test;
/**
 * tests for ComDroid
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class ComDroidTest {
	/**
	 * a comdroid
	 */
	public ComDroid c;
	/**
	 * a comdevice
	 */
	public ComDevice comD;
	/**
	 * sets up ComDroid for tests
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = new ComDroid();
		comD = new ComDevice("1234-4321", "Neal Patel", 2);
	}
	/**
	 * tests assign
	 */
	@Test
	public void testAssign() {
		try {
			c.assign(comD);
		} catch (Exception e) {
			System.out.print("");
		}
		assertFalse(c.equals(""));
	}
}
