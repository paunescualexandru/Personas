 /***********************************************************
 WikiSort (public domain license)
 https://github.com/BonzaiThePenguin/WikiSort
 
 to run:
 javac WikiSort.java
 java WikiSort
***********************************************************/
package wikisort;

//import java.util.*;
//import java.lang.*;
//import java.io.*;
//import wikisort.TestComparator;
//import wikisort.MyMap;
//import wikisort.Range;
//import wikisort.TestingMostlyEqual;
//import wikisort.TestingMostlyDescending;
//import wikisort.SortRandom;
//import wikisort.TestingMostlyAscending;
//import wikisort.TestingRandomFew;
//import wikisort.MergeSorter;
//import wikisort.Testing;
//import wikisort.TestingJittered;
//import wikisort.TestingAscending;
//import wikisort.TestingEqual;
//import wikisort.TestingDescending;
//import wikisort.TestingAppend;
//import wikisort.TestingRandom;

/**
 * the performance of WikiSort here seems to be completely at the mercy of the JIT compiler
 * sometimes it's 40% as fast, sometimes 80%, and either way it's a lot slower than the C code
 * @author Dinamo
 */
public class WikiSort {
    
    public static double Seconds() {
        return System.currentTimeMillis()/1000.0;
    }

    // make sure the items within the given range are in a stable order
    // if you want to test the correctness of any changes you make to the main WikiSort function,
    // call it from within WikiSort after each step
    public static void Verify(MyMap array[], Range range, TestComparator comp, String msg) {
        for (int index = range.start + 1; index < range.end; index++) {
                // if it's in ascending order then we're good
                // if both values are equal, we need to make sure the index values are ascending
                if (!(comp.compare(array[index - 1], array[index]) < 0 ||
                          (comp.compare(array[index], array[index - 1]) == 0 && array[index].key > array[index - 1].key))) {

                        //for (int index2 = range.start; index2 < range.end; index2++)
                        //	System.out.println(array[index2].value + " (" + array[index2].index + ")");

                        System.out.println("failed with message: " + msg);
                        throw new RuntimeException();
                }
        }
    }
}

