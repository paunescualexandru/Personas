/*
 * Program to read a list of urls from a .txt file and compress it into a .dat file
 */
package compress;

import wikisort.MyMap;
import wikisort.TestComparator;
import wikisort.WikiSorter;

/**
 * Program to read a list of urls from a .txt file and compress it into a .dat file
 * Program will be used from a command prompt window using following command:
 * java Compress sourcefilename.txt compressfilename.dat
 * @author Dinamo
 */
public class Compress {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("expected two arguments: sourceFileName  & destinationFileName ");
        } else {
            String sourceFileName = args[0];
            String destinationFileName = args[1];
            int max_size = ReadFile.getUrlListLength(sourceFileName);
            TestComparator comp = new TestComparator();
            MyMap[] array1;
            WikiSorter<MyMap> Wiki = new WikiSorter<>();
            System.out.println("running WikiSort");
            int total = max_size;
            array1 = new MyMap[total];
            ReadFile.getNextUrlFromFile(sourceFileName, array1, total);
            for (int index = 0; index < total; index++) {
                MyMap currentElement = array1[index];
                System.out.println("Index= " + currentElement.key + " URL= " + currentElement.url);
            }
            Wiki.Sort(array1, comp);
            Zip.compress(array1, destinationFileName);
            System.out.println("passed!");
            for (int index = 0; index < total; index++) {
                MyMap currentElement = array1[index];
                System.out.println("Index= " + currentElement.key + " URL= " + currentElement.url);
            }
        }
    }
}
