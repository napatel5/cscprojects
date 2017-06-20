package edu.ncsu.csc216.androtech.model.devices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.androtech.model.util.SimpleIterator;
/**
 * Test for device list
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class DeviceListTest {
	/**
	 * a device list
	 */
	public DeviceList d;
	/**
	 * a comdevice
	 */
	public ComDevice c;
	/**
	 * a vr device
	 */
	public VRDevice v;
	/**
	 * setup method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		d = new DeviceList();
		c = new ComDevice("1234-4321", "Neal Patel", 2);
		v = new VRDevice("4321-1234", "Stuart Wells", 1);
	}
	/**
	 * tests iterator
	 */
	@Test
	public void testIterator() {
		d.add(c);
		d.add(v);
		SimpleIterator<Device> simple = d.iterator();
		assertTrue(simple.hasNext());
		assertTrue(simple.next().equals(c));
	}
	/**
	 * tests remove
	 */
	@Test
	public void testRemove() {
		d.add(c);
		d.remove("Neal", 0);
		assertFalse(d.iterator().hasNext());
	}
	/**
	 * tests add
	 */
	@Test
	public void testAdd() {
		d.add(c);
		d.add(v);
		assertTrue(d.iterator().hasNext());
	}
	/**
	 * tests filtered list
	 */
	@Test
	public void testFilteredList() {
		d.add(c);
		d.add(v);
		String s = d.filteredList("Stuart");
		assertTrue(s.contains("Stuart"));
	}

}
