/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DeflaterOutputStream;

/**
 *
 * @author Dinamo
 */
public class Zip {

    public static void compress(String file1, String file2) {
        //Assign the original file : file to 
        //FileInputStream for reading data
        FileInputStream fis = null;
        DeflaterOutputStream dos = null;
        try {
            fis = new FileInputStream(file1);
            //Assign compressed file:file2 to FileOutputStream 
            FileOutputStream fos = new FileOutputStream(file2);
            //Assign FileOutputStream to DeflaterOutputStream 
            dos = new DeflaterOutputStream(fos);

            //read data from FileInputStream and write it into DeflaterOutputStream 
            int data;
            while ((data = fis.read()) != -1) {
                dos.write(data);
            }
            //close the file 
            fis.close();
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
