/**
 * 
 */
package edu.ncsu.csc216.androtech.model.devices;

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.androtech.model.util.SimpleIterator;

/**
 * Collection of devices
 * 
 * @author Stuart Wells
 * @author Neal Patel
 *
 */
public class DeviceList {
	
	private Node head;
	/**
	 * parses a file and creates a list of devices
	 * 
	 * @param s parses a file
	 */
	public DeviceList(Scanner s){
		String cur;
		String curLine;
		Scanner thisLine;
		
		String dKind;
		int dTier;
		String dSerial;
		String oName = "";
		if(s != null){
			while(s.hasNextLine()){
				curLine = s.nextLine();
				thisLine = new Scanner(curLine);
				if(thisLine.hasNext()){
					cur = thisLine.next();
					if((cur.toUpperCase().equals("V") || cur.toUpperCase().equals("C")) && thisLine.hasNext()){
						dKind = cur.toUpperCase();
						cur = thisLine.next();
						if(thisLine.hasNext()){
							if(Integer.parseInt(cur) > 3) {
								dTier = 3;
							} else if(Integer.parseInt(cur) < 0) {
								dTier = 0;
							} else {
								dTier = Integer.parseInt(cur);
							}
						
							cur = thisLine.next();
							if(thisLine.hasNext()){
								dSerial = cur;
								oName = "";
								while(thisLine.hasNext()){
									cur = thisLine.next();
									oName += cur;
									if(thisLine.hasNext()){
										oName += " ";
									}
								}
								try{
									if(dKind.equals("C")) {
										this.add(new ComDevice(dSerial, oName, dTier));
									} else {
										this.add(new VRDevice(dSerial, oName, dTier)); // Swap serial name
									}
								} catch(Exception e) {
									System.out.print("ADF");
								}
							}
						}
					}
				}
			}
		}
	}
	/**
	 * makes head equal null
	 */
	public DeviceList() {
		head = null;
	}
	/**
	 * an iterator of devices
	 * 
	 * @return simple iterator of devices
	 */
	public SimpleIterator<Device> iterator() {
		return new Cursor();
	}
	/**
	 * removes device from device list
	 * 
	 * @param filter string of the filter to find device
	 * @param position int position of the device in the list
	 * @return Device that is to be removed
	 */
	public Device remove(String filter, int position) {
		int conVar = 0;
		Node pointer = head;
		Device toReturn = null;
		if(head == null){
			return null;
		}
		if(pointer.d.meetsFilter(filter)){
			conVar++;
		}
		if(conVar >= position){
			toReturn = pointer.d;
			head = pointer.next;
		} else {
			while(conVar < position){
				if(pointer.next.d.meetsFilter(filter)){
					conVar++;
				}
				if(conVar != position){
					pointer = pointer.next;
				}
			}
			toReturn = pointer.next.d;
			pointer.next = pointer.next.next;
		}
		return toReturn;
	}
	/**
	 * adds a device to DeviceList
	 * 
	 * @param toAdd device to be added to the list
	 */
	public void add(Device toAdd) {
		if(head == null){
			head = new Node(toAdd, null);
		} else {
			Node pointer = head;
			if(pointer.d.getTier() < toAdd.getTier()){
				head = new Node(toAdd, pointer);
			} else {
				while(pointer.next != null){
					if(pointer.next.d.getTier() < toAdd.getTier()){
						pointer.next = new Node(toAdd, pointer.next);
						break;
					}
					pointer = pointer.next;
				}
				if(pointer.next == null){
					pointer.next = new Node(toAdd, null);
				}
			}
		}
		
	}
	
	/*
	private Node findTrailingNode(String l, int i) {
		
	}
	*/
	/**
	 * returns the filtered list of devices
	 * 
	 * @param filter string filter to narrow display of devices
	 * @return string of filtered devices
	 */
	public String filteredList(String filter) {
		String toReturn = "";
		String newline = System.getProperty("line.separator");
		try{
			if(head != null){
				Node pointer = head;
				while(pointer != null){
					if(pointer.d.meetsFilter(filter)){
						toReturn += pointer.d;
						toReturn += newline;
					}
					pointer = pointer.next;
				}
			}
		} catch(Exception e) {
			System.out.println("");
		}
		return toReturn;
	}
	
	/**
	 * node class for a linked list
	 * 
	 * @author Stuart Wells
	 * @author Neal Patel
	 */
	public class Node {
		/**
		 * next node
		 */
		public Node next;
		/**
		 * a device
		 */
		public Device d;
		/**
		 * constructor for a node
		 * 
		 * @param d a device in the node
		 * @param n a node
		 */
		public Node(Device d, Node n) {
			this.d = d;
			this.next = n;
		}
	}
	
	/**
	 * an iterator to be used by a subclass
	 * 
	 * @author Stuart Wells
	 * @author Neal Patel
	 */
	public class Cursor implements SimpleIterator<Device> {
		
		private Node cursor;
		
		private Cursor() {
			cursor = head;
		}
		/**
		 * returns true if the cursor has a next value
		 * 
		 * @return boolean whether cursor has next
		 */
		public boolean hasNext() {
			if(cursor != null && cursor.next != null){
				return true;
			}
			return false;
		}
		/**
		 * returns a device that is next
		 * 
		 * @return Device that is next
		 */
		public Device next() {
			if (cursor == null){
				throw new NoSuchElementException();
			}
			Device info = cursor.d;
			cursor = cursor.next;
			return info;
		}
	}
}
