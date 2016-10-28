package test;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Test {

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4};
        reverseArray2(x, 0, x.length-1);
        System.out.println(Arrays.toString(x));
        System.out.println(binarySearchRecursion(x, 3, 0, x.length));
//        System.out.println(linearSum(x, x.length));
        System.out.println(binarySum(x, 0, x.length-1));
    }

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j <= i; j++) {
                total += x[j];
                System.out.println(" i: " + x[i] + "  j: " + x[j]);
            }
            a[i] = total / (i + 1);
        }
        return a;
    }
    
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double total = 0;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            total += x[i];
            a[i] = total / (i+1);
        }
        return a;
    }
    
    public static void reverseArray(int[] A, int i, int j) {
        if(i < j) {
            int temp = A[i];    // storing values of i
            A[i] = A[j];
            A[j] = temp;
            reverseArray(A, i+1, j-1);
        }       
    }
    
    public static void reverseArray2(int[] data, int low, int high) {
        // you only need to define low and high when
        // using iterative methods
        low = 0;
        high = data.length-1;
        while(low <= high) {
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }
    
    public static boolean binarySearchRecursion(int[] data, int target, int low, int high) {
        boolean cond = false;
        if(low > high) {
            cond = false;
        } else {
            int mid = (low + high)/2;
            if(target == mid) {
                cond = true;
            } else if(target < data[mid]) {
                cond = binarySearchRecursion(data, target, low, mid - 1);
            } else {
                cond = binarySearchRecursion(data, target, mid + 1, high);
            }
        }
        return cond;
    }
    
    public static boolean binarySearchIteration(int[] data, int target, int low, int high) {
        // you have to define your low and high in this case
        // usually the first element and the last element of data
        low = 0;
        high = data.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(target == data[mid]) {
                return true;
            } else if(target < data[mid])  {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    
    // the Big-O: O(log n)
    public static int binarySum(int[] data, int low, int high) {
        if (low > high) {
            return 0;
        } else if (low == high) {
            return data[low];
        } else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    // the Big-O: O(n)
    public static int linearSum(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            return linearSum(data, n - 1) + data[n - 1];
        }
    }
    
    
    
}
