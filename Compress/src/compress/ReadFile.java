/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Dinamo
 */
public class ReadFile {

    public static void getNextUrlFromFile(String sourceFileName, MyMap[] array, int total) {
        BufferedReader reader = null;
        String url = "";
        try {
            // read url from sourceFileName:
            final File sourceFile = new File(sourceFileName);
            reader = new BufferedReader(new FileReader(sourceFile));
            // loading value in array
            for (int index = 0; index < total; index++) {
                url = reader.readLine();
                MyMap item = new MyMap();
                item.key = index;
                item.url = url;
                //double randomValue = Math.random() * 1000;
                //item.url = String.valueOf(randomValue);
                array[index] = item;
                //array2[index] = item;
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
