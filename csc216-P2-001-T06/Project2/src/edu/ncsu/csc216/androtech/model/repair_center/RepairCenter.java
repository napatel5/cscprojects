package edu.ncsu.csc216.androtech.model.repair_center;

import java.util.Random;

import edu.ncsu.csc216.androtech.model.devices.*;

/**
 * RepairCenter class that stores the TechDroids
 * 
 * @author Stuart Wells
 * @author Neal Patel
 *
 */

public class RepairCenter {

	private static final int MAX_DROIDS = 30;
	//private static final int DEFAULT_SIZE = 5;
	
	private TechDroid[] droids;
	private int numVRDroids;
	
	int size;
	
	/**
	 * Constructor for RepairCenter
	 */
	public RepairCenter(){
		TechDroid.startDroidNumberingAt01();
		droids = new TechDroid[30];
		droids[3] = new ComDroid();
		droids[2] = new ExpertDroid();
		droids[1] = new VRDroid();
		droids[4] = new ComDroid();
		droids[0] = new VRDroid();
		size = 5;
		numVRDroids = 3;
	}
	
	/*
	private void initDroids(int numDroids){
		VRDroid v = new 
	}
	*/
	
	/**
	 * Adds a TechDroid to droids
	 */
	public void addTechDroid(){
		if (size != MAX_DROIDS) {
			if((double)numVRDroids / (double)(size + 1) > .33){
				droids[size] = new ComDroid();
			} else {
				Random rand = new Random();
				if(rand.nextInt(3) < 1){
					for(int i = 0; i < size - 1; i++){
						if(droids[i].getDroidID().endsWith("C") || droids[i] == null){
							for(int j = size - 1; j >= i; j--){
								droids[j + 1] = droids[j];
							}
							droids[i] = new ExpertDroid();
							numVRDroids += 1;
							i = MAX_DROIDS;
						}
					}
				} else {
					for(int i = size - 1; i >= 0; i--){
						droids[i + 1] = droids[i];
					}
					droids[0] = new VRDroid();
					numVRDroids += 1;
				}
			}
			size++;
		}
	}
	
	/**
	 * Returns the number of available droids
	 * 
	 * @return int of number of available droids
	 */
	public int numberOfAvailableDroids() {
		int toReturn = 0;
		for(int i = 0; i < size; i++){
			if(!(droids[i].isAssigned())){
				toReturn++;
			}
		}
		return toReturn;
	}
	
	/**
	 * Retrieves from the index in droids
	 * 
	 * @param droidIndex index to retrieve from
	 * @return TechDroid at the index
	 */
	public TechDroid getDroidAt(int droidIndex){
		return droids[droidIndex];
	}
	
	/**
	 * Returns size
	 * @return size
	 */
	public int totalNumberOfDroids(){
		return size;
	}
	
	/**
	 * Tells a droid to release a device
	 * @param releaseIndex droid's index
	 * @return Device that was released
	 */
	public Device release(int releaseIndex){
		if(releaseIndex >= 0 && releaseIndex <= 29){
			return droids[releaseIndex].release();
		}
		return null;
	}
	
	/**
	 * Returns a printable string of the droids
	 * @return String of the droids
	 */
	public String printDroids(){
		String newline = System.getProperty("line.separator");
		String droidList = "";
		for (int i = 0 ; i < size ; i++) {
			droidList += (droids[i] + newline);
		}
		return droidList;
	}
	
}
