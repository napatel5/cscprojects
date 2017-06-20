package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * tests for expert droid
 * 
 * @author Neal Patel
 * @author Stuart Wells
 */
public class ExpertDroidTest {
	/**
	 * an expert droid
	 */
	public ExpertDroid eD;
	/**
	 * sets up expert droid for testing
	 * 
	 * @throws Exception for setup
	 */
	@Before
	public void setUp() throws Exception {
		eD = new ExpertDroid();
	}
	/**
	 * constructor for expert droid
	 */
	@Test
	public void testExpertDroid() {
		assertFalse(eD.equals(""));
	}

}
