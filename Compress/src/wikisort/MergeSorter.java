/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikisort;

import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Dinamo
 */
public class MergeSorter<T> {
	// n^2 sorting algorithm used to sort tiny chunks of the full array
	public void InsertionSort(T array[], Range range, Comparator<T> comp) {
		for (int i = range.start + 1; i < range.end; i++) {
			T temp = array[i];
			int j;
			for (j = i; j > range.start && comp.compare(temp, array[j - 1]) < 0; j--)
				array[j] = array[j - 1];
			array[j] = temp;
		}
	}
	
	// standard merge sort, so we have a baseline for how well WikiSort works
	public void SortR(T array[], Range range, Comparator<T> comp, T buffer[]) {
		if (range.length() < 32) {
			// insertion sort
			InsertionSort(array, range, comp);
			return;
		}
		
		int mid = range.start + (range.end - range.start)/2;
		Range A = new Range(range.start, mid);
		Range B = new Range(mid, range.end);
		
		SortR(array, A, comp, buffer);
		SortR(array, B, comp, buffer);
		
		// standard merge operation here (only A is copied to the buffer)
		java.lang.System.arraycopy(array, A.start, buffer, 0, A.length());
		int A_count = 0, B_count = 0, insert = 0;
		while (A_count < A.length() && B_count < B.length()) {
			if (comp.compare(array[A.end + B_count], buffer[A_count]) >= 0) {
				array[A.start + insert] = buffer[A_count];
				A_count++;
			} else {
				array[A.start + insert] = array[A.end + B_count];
				B_count++;
			}
			insert++;
		}
		
		java.lang.System.arraycopy(buffer, A_count, array, A.start + insert, A.length() - A_count);
	}
	
	public void Sort(T array[], Comparator<T> comp) {
		@SuppressWarnings("unchecked")
		T[] buffer = (T[]) new Object[array.length];
		SortR(array, new Range(0, array.length), comp, buffer);
	}
	
	public static <T> void sort(T[] array, Comparator<T> comp) {
		new MergeSorter<T>().Sort(array, comp);
	}
}























