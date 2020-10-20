/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikisort;

/**
 *
 * @author Dinamo
 */
public class Pull {
	public int from, to, count;
	public Range range;
	public Pull() { range = new Range(0, 0); }
	void reset() {
		range.set(0, 0);
		from = 0;
		to = 0;
		count = 0;
	}
}
