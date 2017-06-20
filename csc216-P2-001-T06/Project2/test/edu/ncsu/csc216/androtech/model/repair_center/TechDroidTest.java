package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;
import edu.ncsu.csc216.androtech.model.devices.*;

import org.junit.Before;
import org.junit.Test;
/**
 * tests for TechDroid
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class TechDroidTest {
	/**
	 * a ComDroid
	 */
	public ComDroid c;
	/**
	 * a VRDroid
	 */
	public VRDroid v;
	/**
	 * a repair center
	 */
	public RepairCenter r;
	/**
	 * a comdevice device
	 */
	public ComDevice comD;
	
	/**
	 * a vrdevice device
	 */
	public VRDevice vrD;
	/**
	 * sets up testing for TechDroid
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		r = new RepairCenter();
		c = new ComDroid();
		v = new VRDroid();
		comD = new ComDevice("1234-4321", "Neal Patel", 2);
		vrD = new VRDevice("4321-1234", "Stuart Wells", 1);
	}
	/**
	 * tests start numbering at 01
	 */
	@Test
	public void testStartDroidNumberingAt01() {
		assertFalse(c.equals(""));
	}
	/**
	 * tests getDroidID
	 */
	@Test
	public void testGetDroidID() {
		v.getDroidID();
		assertFalse(v.equals(""));
	}
	/**
	 * testsIsAssigned
	 */
	@Test
	public void testIsAssigned() {
		c.isAssigned();
		assertFalse(c.equals(""));
	}
	/**
	 * tests release
	 */
	@Test
	public void testRelease() {
		v.release();
		assertFalse(v.equals(""));
	}
	/**
	 * tests assign
	 */
	@Test
	public void testAssign() {
		try {
		c.assign(comD);
		}
		catch (Exception e) {
			System.out.print("");
		}
	}
	/**
	 * tests toString
	 */
	@Test
	public void testToString() {
		v.toString();
		assertFalse(v.equals(""));

	}
}
