package recursion;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] A = {60, 35, 81, 98, 14, 47};
        System.out.println(Arrays.toString(SelectionSorting(A, A.length)));
    }

    public static int[] SelectionSorting(int[] A, int n) {
        // The selection sort scans the array, starting at position 0, and
        // locates the element with the smallest value.
        int startScan;
        int minIndex;
        int minValue;
        int index;
        for (startScan = 0; startScan < (A.length - 1); startScan++) {
            // assume the smalles value is the first element in the scannable area
            minIndex = startScan;
            minValue = A[minIndex];
            // start the scan at index 1;
            for (index = startScan + 1; index < (A.length); index++) {
                if (A[index] < minValue) {
                    minValue = A[index];
                    minIndex = index;
                }
            }

            // swap element with the smalles value 
            // with the first element in the scannable area
            A[minIndex] = A[startScan];
            A[startScan] = minValue;
        }
        return A;
    }

}
