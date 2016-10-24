package recursion;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Q4Asg02MySolution {

    public static void main(String[] args) {
        
        int[] A = {60, 35, 81, 98, 14, 47, 43, 12, 6, 87,12, 11, 90, 23, 66, 34, 50, 81, 87, 22,1,4,2,8,101,7};
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(MySolution(A, A.length)));
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;
        //TimeUnit.MILLISECONDS.toSeconds(timeElapsed);
        System.out.println("algo1: " + TimeUnit.MILLISECONDS.toSeconds(timeElapsed));
        
        
        long start2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(SelectionSorting(A, A.length)));
        long end2 = System.currentTimeMillis();
        long timeElapsed2 = end2 - start2;
        System.out.println("algo2: " + TimeUnit.MILLISECONDS.toSeconds(timeElapsed2));
        
    }

    public static int[] MySolution(int[] A, int n) {
        int[] var = new int[n];
        for (int k = 0; k < n - 1; k++) {
            var[k] = 0;
        }
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (A[i] <= A[j]) {
                    var[j] = var[j] + 1;
                    System.out.println("i: " + i + "; j: " + j + " My var array at TRUE: " + Arrays.toString(var));
                } else {
                    var[i] = var[i] + 1;
                    System.out.println("i: " + i + "; j: " + j + " My var array at FALSE: " + Arrays.toString(var));
                }
            }
        }

        int[] S = new int[n];
        for (int h = 0; h <= n - 1; h++) {
            S[var[h]] = A[h];
        }
        return S;
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
