package stack.linked_stack;

import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedIntegerStack S = new LinkedIntegerStack();

        int x = 3;
        int[] A = {123, 73, 39, 12, 14, 9};

        modPair(A, x, S);

        System.out.println(S.size());

        displayOut(S);
    }

    public static boolean pushELem(int curr, int next, int x) {
        return curr % next == x;
    }

    public static void modPair(int[] A, int x, LinkedIntegerStack ls) {
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = i; j < A.length - 1; j++) {
                if (pushELem(A[i], A[j + 1], x)) {
                    ls.push(A[j + 1]);
                    ls.push(A[i]);
                    ls.push(j);
                    ls.push(i);
                }
            }
        }
    }

    public static void displayOut(LinkedIntegerStack ls) {
        int[] B = new int[ls.size()];
        for (int i = 0; i < B.length; i++) {
            B[i] = ls.pop();
        }
        System.out.println(Arrays.toString(B));
        // every four elements print the result
        // one pair for indices and one for mod pair
        for (int i = 0; i < B.length - 3; i += 4) {
            System.out.println("Indices " + B[i] + " & " + B[i + 1] + " with values " + B[i + 2] + " & " + B[i + 3]);
        }

    }
    
    

}
