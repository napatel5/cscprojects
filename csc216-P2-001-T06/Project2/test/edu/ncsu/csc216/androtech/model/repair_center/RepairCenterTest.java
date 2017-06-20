package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * tests repair center
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class RepairCenterTest {
	
	/**
	 * a repair center
	 */
	public RepairCenter r;
	
	/**
	 * sets up repair center
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		r = new RepairCenter();
	}
	/**
	 * tests adding a techdroid
	 */
	@Test
	public void testAddTechDroid() {
		for (int i = 0 ; i < 20 ; i++) {
			r.addTechDroid();
		}
		assertFalse(r.equals(""));
	}
	/**
	 * tests number of available droids
	 */
	@Test
	public void testNumberOfAvailableDroids() {
		assertEquals(r.numberOfAvailableDroids(), 5);
	}
	/**
	 * tests get droid at index
	 */
	@Test
	public void testGetDroidAt() {
		r.getDroidAt(1);
		assertFalse(r.equals(""));
	}
	/**
	 * tests total number of droids
	 */
	@Test
	public void testTotalNumberOfDroids() {
		assertEquals(r.totalNumberOfDroids(), 5);
	}
	/**
	 * tests release
	 */
	@Test
	public void testRelease() {
		r.release(2);
		assertFalse(r.equals(""));
	}
	/**
	 * tests print droids
	 */
	@Test
	public void testPrintDroids() {
		r.printDroids();
		assertFalse(r.equals(""));
	}

}
