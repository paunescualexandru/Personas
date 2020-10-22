/*
 * Lookup into the decompressed file created at point 1 to see if a given url is present in the file.
 * If it is present the program will return “present” message..
 */
package lookup;

import boyermoorehorspoolsearch.BoyerMooreHorspoolSearch;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lookup into the decompressed file created at point 1 to see if a given url is present in the file.
 * If it is present the program will return “present” message..
 * Program will be used from a command prompt window using following command:
 * java lookup compressfilename.dat urltosearchstring
 * @author Dinamo
 */
public class Lookup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("expected two arguments: sourceFileName  & destinationFileName ");
        } else {
            BufferedReader reader = null;
            String url = "";
            String sourceFileName = args[0];
            String urlToSearch = args[1];
            String destinationFileName = "C:\\Compress\\temp.txt";
            // indetify the number urls
            final File sourceFile = new File(sourceFileName);
            try {
                // unzip the .dat file
                UnZip.unZip(sourceFileName, destinationFileName);
            } catch (IOException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                reader = new BufferedReader(new FileReader(destinationFileName));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            }
            //int returnValue = Interpolation.interpolationSearch(urls, urlToSearch, numberOfLines);
            int returnValue = BoyerMooreHorspoolSearch.bmhs(urlToSearch.toCharArray(), url.toCharArray());
            if (returnValue == -1) {
                System.out.println("absent");
            } else {
                System.out.println("present");
            }

        }

    }
}
