package recursion;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Solvable {

    public static void main(String[] args) {
        // Test solvable
        int[] testSolvableSet = {5, 6, 4, 1, 3, 4, 2, 5, 3, 0};
        int[] testInSolveableSet = {3, 1, 2, 3, 0};

        System.out.println("Is the set '{3, 6, 4, 1, 3, 4, 2, 5, 3, 0}' @ 0 solveable? " + solvable(0, testSolvableSet) + " (should be true)");
//        System.out.println("Is the set '{3, 6, 4, 1, 3, 4, 2, 5, 3, 0}' @ 0 solveable? " + solvable(0, testSolvableSet) + " (should be true)"); // test for proper clones
        System.out.println("Is the set '{3, 1, 2, 3, 0}' @ 0 solveable? " + solvable(0, testInSolveableSet) + " (should be false)");
    }

    public static boolean solvable(int currentIndex, int[] ourArray) {
        
        int lenOfOurArray = ourArray.length;
        int indexOfZero = lenOfOurArray - 1;
        
        /*
        References
        ---------------------------------------------------------
        currentIndex: 
            an index of current position in our array
        
        ourArray[currentIndex]:
            means the value of our array at current index
        
        MOVING RIGHT:
            ourArray[currentIndex + ourArray[ currentIndex ]]
                the value of our array at current index PLUS
                the value of that currentIndex
        
        MOVING LEFT:
            currentIndex - ourArray[currentIndex]
                the currentIndex MINUS the value of our array at
                current index
        
        BASE CASE (returning true):
            if we made it to the end where the value is set to 0
            return true game is over
        
        
        SPECIAL CASES (returning false):
            1. if the value of our array at current index is 0
            means we can't move any further
            2. if the value of our array at current index or starting index
            is greater than the length of our array means it would overflow
        
        */
        if (currentIndex == indexOfZero) {
            return true;
        } else if (ourArray[currentIndex] == 0){
            return false;
        } else if(ourArray[currentIndex] > indexOfZero) {
            return false;
        }

        
        
        // check if we can go left
        if (currentIndex - ourArray[currentIndex] >= 0) {
            // check if the position to the left is a valid move
            if (ourArray[currentIndex - ourArray[currentIndex]] >= 0) {
                //
                // try to move to that square
                //

                // clone the squares array (so we can modify it a little)
                int[] tempSquares = ourArray.clone();

                // set the current index as already hit (can't go back)
                tempSquares[currentIndex] = -1;

                // Try moving to the left
                if (solvable(currentIndex - ourArray[currentIndex], tempSquares)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        
        /*
        {3, 6, 4, 1, 3, 4, 2, 5, 3, 0};
        
        0 - 3 >= 0 : false then try to move right
        
        move right
            our array at current index + the value of our array
            at that current index
            
        Reminder:
        currentIndex = 0
        ourArray[currentIndex] = 3
            ourArray[ currentIndex + ourArray[ currentIndex ] ] :
                ourArray[0 +  3] = 1 is less than
                our array length, this means we can move to the right
                
            
        */
        
        if (ourArray[currentIndex + ourArray[currentIndex]] < lenOfOurArray) {
            if (ourArray[currentIndex + ourArray[currentIndex]] >= 0) {
                //
                // try to move to the right side square
                //

                // clone the squares array (so we can modify it a little)
                int[] tempSquaresRight = ourArray.clone();

                // set the current index as already hit (can't go back)
                tempSquaresRight[currentIndex] = -1;

                // Try moving to the right
                return solvable(currentIndex + ourArray[currentIndex], tempSquaresRight);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
