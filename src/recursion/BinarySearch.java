package recursion;

public class BinarySearch {

    // tail recursion
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        boolean cond;
        if (low > high) {
            cond = false; // interval empty; no match
        } else {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                cond = true; // found a match
            } else if (target < data[mid]) {
                System.out.println("here1");
                cond =  binarySearch(data, target, low, mid - 1);
            } else {
                System.out.println("here2");
                cond = binarySearch(data, target, mid + 1, high);
            }
        }
        return cond;
    }
    
    public static void main(String[] args) {
        int[] data = {2, 4, 3, 7, 9, 10};
        System.out.println(binarySearch(data, 7, 0, data.length));
    }

}
