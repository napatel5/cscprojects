/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

/**
 * interface for prioritizables
 * 
 * @author Stuart Wells
 * @author Neal Patel
 */
public interface Prioritizable {
	/**
	 * gets the tier of a prioritizable
	 * 
	 * @return int of the tier
	 */
	public int getTier();
	/**
	 * compares tier of prioritizables
	 * 
	 * @param p prioritizable to compare
	 * @return int of the tier
	 */
	public int compareToTier(Prioritizable p);
}
