package recursion;

public class BinarySearch {

    // tail recursion
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false; // interval empty; no match
        } else {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true; // found a match
            } else if (target < data[mid]) {
                return binarySearch(data, target, low, mid - 1);
            } else {
                return binarySearch(data, target, mid + 1, high);
            }
        }
    }

}
