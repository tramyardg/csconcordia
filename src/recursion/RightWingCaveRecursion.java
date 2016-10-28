package recursion;

import java.util.Arrays;

/**
 *
 * @author Raymart De Guzman 40010443
 */
public class RightWingCaveRecursion {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int[] myRand = randomElemArray(10);
            boolean game = righWingCave(0, myRand);
            String res = game ? "Solvable!" : "Unsolvable!";

            System.out.println("#" + (i + 1) + " Is this configuration solvable? " + Arrays.toString(myRand) + "? " + res);
        }
    }

    /**
     * Simulate a recursion version of rightWingCave game.
     * @param currentIndex starting position usually at index 0
     * @param ourArray the array to be determine if is solvable
     * @return return true if solvable, otherwise return false;
     */
    public static boolean righWingCave(int currentIndex, int[] ourArray) {
        int lenOfOurArray = ourArray.length;
        int indexOfZero = lenOfOurArray - 1;

        // BASE CASES:
        // if current position has the same position as goal 
        // then it is solved
        if (currentIndex == indexOfZero) {
            return true;
        } // if the current value of the current position is greater than
        // the goal then cannot move any further
        else if (ourArray[currentIndex] > indexOfZero) {
            return false;
        } // if any value after the first elements is greater
        // than the index of goal then flag false as this will go index out of
        // bounds
        else if ((currentIndex + ourArray[currentIndex]) > indexOfZero) {
            return false;
        }

        // check first if we can move left
        if (currentIndex - ourArray[currentIndex] >= 0) {
            if (ourArray[currentIndex - ourArray[currentIndex]] >= 0) {

                int[] leftSquares = ourArray.clone();

                leftSquares[currentIndex] = -1;

                 return righWingCave(currentIndex - ourArray[currentIndex], leftSquares);
            } else {
                return false; // can't move left
            }
        }

        // check first if we ca move right 
        if ((indexOfZero - currentIndex) > currentIndex && ourArray[currentIndex + ourArray[currentIndex]] < lenOfOurArray) {
            if (ourArray[currentIndex + ourArray[currentIndex]] >= 0) {

                int[] rightSquares = ourArray.clone();

                // we can't go back 
                rightSquares[currentIndex] = -1;
                    
                return righWingCave(currentIndex + ourArray[currentIndex], rightSquares);
            } else {
                return false; // can't move right return false;
            }
        } else {
            return false; 
        }
    }

    /**
     * Created a random integer and populate an array with those
     * integer.
     * @param n number of elements of array to be created
     * @return return a random array with random values created
     */
    public static int[] randomElemArray(int n) {
        int[] A = new int[n];
        A[A.length - 1] = 0;
        for (int i = 0; i < n - 1; i++) {
            A[i] = 1 + (int) (Math.random() * ((9 - 1) + 1));
        }
        return A;
    }

}
