/**
 * 
 */
package edu.ncsu.csc216.androtech.model.util;

/**
 * general iterator interface
 * 
 * @author Stuart Wells
 * @author Neal Patel
 * @param <E> element of iterator
 */
public interface SimpleIterator<E> {
	/**
	 * checks if iterator has next
	 * 
	 * @return true is iterator has next
	 */
	public boolean hasNext();
	/**
	 * moves to next
	 * 
	 * @return E the element
	 */
	public E next();
}
