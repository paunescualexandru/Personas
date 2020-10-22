/*
 * Decompress a .dat file compressed with Compress java program
 */
package lookup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

/**
 * Decompress a .dat file compressed with Compress java program
 * @author Dinamo
 */
public class UnZip {
/**
 * Uncompressing a file using an InflaterInputStream 
 * @param file2 compressed file
 * @param file3 decompressed file
 * @throws IOException 
 */
 
    public static void unZip(String file2, String file3) throws IOException {
        //assign Input File : file2 to FileInputStream for reading data 
        FileInputStream fis = new FileInputStream(file2);
        
        //assign output file: file3 to FileOutputStream for reading the data 
        FileOutputStream fos = new FileOutputStream(file3);

        //assign inflaterInputStream to FileInputStream for uncompressing the data 
        InflaterInputStream iis = new InflaterInputStream(fis);

        //read data from inflaterInputStream and write it into FileOutputStream  
        int data;
        while ((data = iis.read()) != -1) {
            fos.write(data);
        }

        //close the files 
        fos.close();
        iis.close();

    }

}
