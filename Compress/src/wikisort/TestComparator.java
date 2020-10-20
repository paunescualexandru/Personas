/*
 *  class to test stable sorting (index will contain its original index in 
 *  the array, to make sure it doesn't switch places with other items)
 */
package wikisort;

import java.awt.BorderLayout;
import java.util.Comparator;

/**
 *
 * @author Dinamo
 */
public class TestComparator implements Comparator<MyMap> {

    private static int comparisons = 0;

    @Override
    public int compare(MyMap a, MyMap b) {
        setComparisons(getComparisons() + 1);
        try{
            if (a.url.compareTo(b.url) < 0) {
                return -1;
            }
            if (a.url.compareTo(b.url) > 0) {
                return 1;
            }
        }catch(Exception e){
            System.out.println("Exception ocured: "+ e);
        }
        return 0;
    }
           

    /**
     * @return the comparisons
     */
    public static int getComparisons() {
        return comparisons;
    }

    /**
     * @param aComparisons the comparisons to set
     */
    public static void setComparisons(int aComparisons) {
        comparisons = aComparisons;
    }
}
