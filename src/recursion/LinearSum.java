package recursion;

public class LinearSum {

    public static void main(String[] args) {
        int[] data = {4, 3, 6, 2, 8};
        System.out.println(linearSum(data, data.length));
    }

    public static int linearSum(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            System.out.println(linearSum(data, n - 1));
        }
        return linearSum(data, n - 1) + data[n - 1];
    }
}
