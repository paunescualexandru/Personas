/*
 *  calculate how to scale the index value to the range within the array
 * the bottom-up merge sort only operates on values that are powers of two,
 * so scale down to that power of two, then use a fraction to scale back again
 */
package wikisort;

/**
 * calculate how to scale the index value to the range within the array
 * the bottom-up merge sort only operates on values that are powers of two,
 * so scale down to that power of two, then use a fraction to scale back again
 * @author Dinamo
 */

public class Iterator {
	public int size, power_of_two;
	public int numerator, decimal;
	public int denominator, decimal_step, numerator_step;
	
	// 63 -> 32, 64 -> 64, etc.
	// this comes from Hacker's Delight
	public static int FloorPowerOfTwo(int value) {
		int x = value;
		x = x | (x >> 1);
		x = x | (x >> 2);
		x = x | (x >> 4);
		x = x | (x >> 8);
		x = x | (x >> 16);
		return x - (x >> 1);
	}
	
	Iterator(int size2, int min_level) {
		size = size2;
		power_of_two = FloorPowerOfTwo(size);
		denominator = power_of_two/min_level;
		numerator_step = size % denominator;
		decimal_step = size/denominator;
		begin();
	}
	
	void begin() {
		numerator = decimal = 0;
	}
	
	Range nextRange() {
		int start = decimal;
		
		decimal += decimal_step;
		numerator += numerator_step;
		if (numerator >= denominator) {
			numerator -= denominator;
			decimal++;
		}
		
		return new Range(start, decimal);
	}
	
	boolean finished() {
		return (decimal >= size);
	}
	
	boolean nextLevel() {
		decimal_step += decimal_step;
		numerator_step += numerator_step;
		if (numerator_step >= denominator) {
			numerator_step -= denominator;
			decimal_step++;
		}
		
		return (decimal_step < size);
	}
	
	int length() {
		return decimal_step;
	}
}
