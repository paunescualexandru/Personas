/*
 * structure to represent ranges within the array
 */
package wikisort;

/**
 *
 * @author Dinamo
 */

public class Range {
	public int start;
	public int end;
	
	public Range(int start1, int end1) {
		start = start1;
		end = end1;
	}
	
	public Range() {
		start = 0;
		end = 0;
	}
	
	void set(int start1, int end1) {
		start = start1;
		end = end1;
	}
	
	int length() {
		return end - start;
	}
}
