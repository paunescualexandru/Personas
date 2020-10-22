/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import org.junit.Test;
import static org.junit.Assert.*;
import wikisort.MyMap;

/**
 *
 * @author Dinamo
 */
public class ReadFileTest {
    
    public ReadFileTest() {
    }

    /**
     * Test of getUrlListLength method, of class ReadFile.
     */
    @Test
    public void testGetUrlListLength() {
        System.out.println("getUrlListLength");
        String sourceFileName = "C:\\Compress\\domains.txt";
        int expResult = 100;
        int result = ReadFile.getUrlListLength(sourceFileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNextUrlFromFile method, of class ReadFile.
     */
    @Test
    public void testGetNextUrlFromFile() {
        System.out.println("getNextUrlFromFile");
        String sourceFileName = "C:\\Compress\\domains.txt";
        MyMap[] array = new MyMap[100] ;
        int total = 100;
        ReadFile.getNextUrlFromFile(sourceFileName, array, total);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
