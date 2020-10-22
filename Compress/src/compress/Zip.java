/*
 * Compress a .txt file containing  urls on each line into a .dat compressed file
 */
package compress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DeflaterOutputStream;
import wikisort.MyMap;

/**
 * Compress a .txt file containing  url`s on each line into a .dat compressed file
 * @author Dinamo
 */
public class Zip {
    /**
     * Compress an array in to a .dat file
     * @param array an array containing more urls
     * @param file2 a compresed .dat file
     */
    public static void compress(MyMap[] array, String file2) {
        //Assign the original file : file to 
        //FileInputStream for reading data
        DeflaterOutputStream dos = null;
        try {
            //Assign compressed file:file2 to FileOutputStream 
            FileOutputStream fos = new FileOutputStream(file2);
            //Assign FileOutputStream to DeflaterOutputStream 
            dos = new DeflaterOutputStream(fos);
            //read data from FileInputStream and write it into DeflaterOutputStream 
            String data;
            int i = 0;
            while (i < array.length) {
                String curentUrl = array[i].url;
                byte[] cuc = curentUrl.getBytes();
                dos.write(cuc);
                dos.write(42);
                i++;
            }
            //close the file 
            dos.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(Zip.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("A file not found exception ocured: " + e);
        } catch (IOException ex) {
            Logger.getLogger(Zip.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("An IO exception ocured: " + ex);
        }
    }
}
