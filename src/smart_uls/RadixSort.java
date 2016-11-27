/**
 * Author: Raymart De Guzman
 */
package smart_uls;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class RadixSort {

    /**
     * @param input
     */
    
    public static void radixsort(int[] input) {
        final int RADIX = 10;
        // declare and initialize bucket array
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RADIX;
        }
    }

}
