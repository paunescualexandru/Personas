/*
 * Program to read
 */
package compress;

import wikisort.MyMap;
import wikisort.TestComparator;
import wikisort.WikiSorter;

/**
 *
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
            int max_size = 100;
            TestComparator comp = new TestComparator();
            // Define array1 adn array2
            MyMap[] array1;
            //MyMap[] array2;
            WikiSorter<MyMap> Wiki = new WikiSorter<>();
            System.out.println("running WikiSort");
            int total = max_size;
            array1 = new MyMap[total];
            //array2 = new MyMap[total];
            ReadFile.getNextUrlFromFile(sourceFileName, array1, total);
            for (int index = 0; index < total; index++) {
                MyMap currentElement = array1[index];
                System.out.println("Index= " + currentElement.key + " URL= " + currentElement.url);
            }
            Wiki.Sort(array1, comp);
//        Wiki.Sort(array2, comp);

//            WikiSort.Verify(array1, new Range(0, total), comp, "test case failed");
//            for (int index = 0; index < total; index++) {
//                if (comp.compare(array1[index], array2[index]) != 0) {
//                    throw new Exception();
//                }
//               if (array2[index].key != array1[index].key) {
//                   throw new Exception();
//                }
//            }
//            for (int index = 0; index < total; index++) {
//                MyMap item = new MyMap();
//                item.key = index;
//                item.url = array1[index].url;
//                array1[index] = item;
//            }
            Zip.compress(sourceFileName, destinationFileName);
            System.out.println("passed!");
            for (int index = 0; index < total; index++) {
                MyMap currentElement = array1[index];
                System.out.println("Index= " + currentElement.key + " URL= " + currentElement.url);
            }
        }
    }
}
