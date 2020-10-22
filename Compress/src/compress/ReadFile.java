/*
 * Reads information from a .txt file returning the number of lines
 */
package compress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import wikisort.MyMap;

/**
 * Reads information from a .txt file returning the number of lines
 * @author Dinamo
 */
public class ReadFile {
    /**
     * Returns the length of urls list
     * @param sourceFileName name of .txt file
     * @return number of lines
     */
public static int getUrlListLength(String sourceFileName){
        BufferedReader reader1 = null;
        String url1 = "";
        int index1 = 0;
        try {
            final File sourceFile = new File(sourceFileName);
            reader1= new BufferedReader(new FileReader(sourceFile));
            while (null != (url1=reader1.readLine())) {
                index1++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                reader1.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return index1;
    }
/**
 *  Returns list of urls as arrays
 * @param sourceFileName the .txt file
 * @param array the array returned
 * @param total number of lines(urls)
 */
    public static void getNextUrlFromFile(String sourceFileName, MyMap[] array, int total) {
        BufferedReader reader = null;
        String url = "";
        try {
            final File sourceFile = new File(sourceFileName);
            reader = new BufferedReader(new FileReader(sourceFile));
            // loading value in array
            for (int index = 0; index < total; index++) {
                url = reader.readLine();
                MyMap item = new MyMap();
                item.key = index;
                item.url = url;
                array[index] = item;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
