package stack.generic_stack;


/**
 *
 * @author RAYMARTHINKPAD
 */
public class GenericDemo {

    public static void main(String[] args) {
        GenericStackV2<Integer> S = new GenericStackV2<>();

        int x = 3;
        int[] A = {123, 73, 39, 12, 14, 9};
        
        modPair(A, x, S);
        
        displayOut(S);
        
        

    }

    public static boolean evalMod(int curr, int next, int x) {
        return curr % next == x;
    }

    public static void modPair(int[] A, int x, GenericStackV2<Integer> gs) {
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = i; j < A.length - 1; j++) {
                if (evalMod(A[i], A[j + 1], x)) {
                    gs.push(A[j + 1]);
                    gs.push(A[i]);
                    gs.push(j);
                    gs.push(i);
                }
            }
        }
    }
    
    public static void displayOut(GenericStackV2<Integer> gs) {
        
        int[] B = new int[gs.size()];
        for (int i = 0; i < B.length; i++) {
            B[i] = gs.pop();
        }
        // every four elements print the result
        // one pair for indices and one for mod pair
        for (int i = 0; i < B.length - 3; i += 4) {
            System.out.println("Indices " + B[i] + " & " + B[i + 1] + " with values " + B[i + 2] + " & " + B[i + 3]);
        }
        

    }
}
