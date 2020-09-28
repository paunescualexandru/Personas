/*
 
 */
package InteractiveCommonDataTypes;

import java.util.Arrays;

/**
 *
 * @author Dinamo
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6, 8, 2, 6, 7, 4, 5, 1, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] arr) {
        boolean ordonat = false;
        while (!ordonat) {
            ordonat = true;
            //<editor-fold defaultstate="collapsed" desc="/*comment*/">
            for (int i = 0; 1 < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    ordonat = false;
//</editor-fold>
                }
            }
        }
return arr;
    }

}


