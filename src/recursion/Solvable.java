package recursion;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Solvable {

    public static void main(String[] args) {
//        int[] A = {4, 8, 5, 2, 3, 5, 1, 6, 4, 0};
//        System.out.println("my array: " + Arrays.toString(A));
//        System.out.println(righWingCave(0, A));
//        System.out.println("");
//        System.out.println(Arrays.toString(randomElemArray(10)));
//        
        for (int i = 0; i < 20; i++) {
            int[] myRand = randomElemArray(10);
            System.out.println("is this solvable? " + Arrays.toString(myRand) + " " + righWingCave(0, myRand));
        }
    }

    public static boolean righWingCave(int currentIndex, int[] ourArray) {
        int lenOfOurArray = ourArray.length;
        int indexOfZero = lenOfOurArray - 1;

        if (currentIndex == indexOfZero) {
            return true;
        } else if (ourArray[currentIndex] == 0) {
            return false;
        } else if (ourArray[currentIndex] > indexOfZero) {
            return false;
        } else if ((currentIndex + ourArray[currentIndex]) > indexOfZero) {
            return false;
        }

//        System.out.println("indexOfZero: " + indexOfZero);
//        int leftGap = currentIndex
        if (currentIndex - ourArray[currentIndex] >= 0) {
            if (ourArray[currentIndex - ourArray[currentIndex]] >= 0) {

                // clone the squares array (so we can modify it a little)
                int[] leftSquares = ourArray.clone();

                // set the current index as already hit (can't go back)
                leftSquares[currentIndex] = -1;

//                System.out.println("left: at index " + (currentIndex + " : value " + ourArray[currentIndex]));
                return righWingCave(currentIndex - ourArray[currentIndex], leftSquares);
            } else {
                return false;
            }
        }

        if ((indexOfZero - currentIndex) > currentIndex && ourArray[currentIndex + ourArray[currentIndex]] < lenOfOurArray) {
            if (ourArray[currentIndex + ourArray[currentIndex]] >= 0) {

                int[] rightSquares = ourArray.clone();

                rightSquares[currentIndex] = -1;

//                System.out.println("right: at index " + (currentIndex + " : value " + ourArray[currentIndex]));
                return righWingCave(currentIndex + ourArray[currentIndex], rightSquares);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static int[] randomElemArray(int n) {
        int[] A = new int[n];
        A[A.length - 1] = 0;
        for (int i = 0; i < n - 1; i++) {
            A[i] = 1 + (int) (Math.random() * ((9 - 1) + 1));
        }
        return A;
    }

}
