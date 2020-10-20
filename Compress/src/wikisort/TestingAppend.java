/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikisort;

/**
 * the last 1/5 of the data is random
 * @author Dinamo
 */
class TestingAppend extends Testing {
	int value(int index, int total) {
		if (index > total - total/5) return SortRandom.nextInt(total);
		return index;
	}
}
