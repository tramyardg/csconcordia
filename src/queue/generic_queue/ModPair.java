package queue.generic_queue;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ModPair {
    
    public static void main(String[] args) {
        GenericQueue<Integer> Q = new GenericQueue<>();

        int x = 3;
        int[] A = {123, 73, 39, 12, 14, 9};
        
        modPair(A, x, Q);
        
    }

    public static boolean evalMod(int curr, int next, int x) {
        return curr % next == x;
    }

    public static void modPair(int[] A, int x, GenericQueue<Integer> Q) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length - 1; j++) {
                if (evalMod(A[i], A[j + 1], x)) {
                    Q.enqueue(i);
                    Q.enqueue(j);
                    Q.enqueue(A[i]);
                    Q.enqueue(A[j + 1]);
                }
            }
        }
        displayOutput(Q, x);
        
    }

    public static void displayOutput(GenericQueue<Integer> Q, int x) {
        System.out.println("All pairs of elements of the array that modulo up to a value of " + x + " are: ");
        int[] B = new int[Q.size()];
        for (int i = 0; i < B.length; i++) {
            B[i] = Q.dequeue(); // dequeue all the elements and save them to an array
        }
        // every four elements print the result
        // one pair for indices and one for mod pair
        for (int i = 0; i < B.length - 3; i += 4) {
            System.out.println("Indices " + B[i] + " & " + B[i + 1] + " with values " + B[i + 2] + " & " + B[i + 3]);
        }

    }

}
