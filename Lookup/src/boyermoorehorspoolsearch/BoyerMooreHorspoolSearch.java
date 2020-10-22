/*
  There are many variations of heuristic implementation of the Boyer-Moore algorithm, 
and simplest one is Horspool variation.
This version of the algorithm is called Boyer-Moore-Horspool, and this variation solved the problem of negative shifts 
(we can read about negative shift problem in the description of the Boyer-Moore algorithm).
Like Boyer-Moore algorithm, worst-case scenario time complexity is O(m * n) 
while average complexity is O(n). Space usage doesn't depend on the size of the pattern, 
but only on the size of the alphabet which is 256 since that is the maximum value of ASCII character in English alphabet:
 */
package boyermoorehorspoolsearch;

/**
  There are many variations of heuristic implementation of the Boyer-Moore algorithm, 
and simplest one is Horspool variation.
This version of the algorithm is called Boyer-Moore-Horspool, and this variation solved the problem of negative shifts 
(we can read about negative shift problem in the description of the Boyer-Moore algorithm).
Like Boyer-Moore algorithm, worst-case scenario time complexity is O(m * n) 
while average complexity is O(n). Space usage doesn't depend on the size of the pattern, 
but only on the size of the alphabet which is 256 since that is the maximum value of ASCII character in English alphabet:
 * @author Dinamo
 */
public class BoyerMooreHorspoolSearch {
    /**
     * Method apply the BoyerMooreHorspoolSearch algorithm
     * @param pattern pattern to search
     * @param text where to search
     * @return returns -1 if pattern is not present in text other returns a positive number
     */
    public static int bmhs(char[] pattern, char[] text) {
        int shift[] = new int[256];
        for (int k = 0; k < 256; k++) {
            shift[k] = pattern.length;
        }
        for (int k = 0; k < pattern.length - 1; k++) {
            shift[pattern[k]] = pattern.length - 1 - k;
        }
        int i = 0, j = 0;
        while ((i + pattern.length) <= text.length) {
            j = pattern.length - 1;

            while (text[i + j] == pattern[j]) {
                j -= 1;
                if (j < 0) {
                    return i;
                }
            }
            i = i + shift[text[i + pattern.length - 1]];
        }
        return -1;
    }
}
