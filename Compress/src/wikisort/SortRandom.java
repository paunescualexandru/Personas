/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikisort;

import java.util.Random;

/**
 *
 * @author Dinamo
 */
class SortRandom {
	public static Random rand;
	public static int nextInt(int max) {
		// set the seed on the random number generator
		if (rand == null) rand = new Random();
		return rand.nextInt(max);
	}
	public static int nextInt() {
		return nextInt(2147483647);
	}
}