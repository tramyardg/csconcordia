package test;

import recursion.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class RightWingCaveQueue {

    public static void main(String[] args) {
//        setupCave();
        int[] A = {2, 8, 4, 3, 5, 8, 2, 9, 4, 0};
        System.out.println(RWC(A, A.length));
    }//end of main

    public static void setupCave() {

        Scanner kb = new Scanner(System.in);
        Random digits = new Random();
        int numOfSquares = 1;

        System.out.println("Welcome to the right wing cave, how many squares would you like to play with? ");

        try {
            numOfSquares = kb.nextInt();
        } catch (Exception e1) {
            System.out.println("Please enter a valid positive integer.");
            setupCave();
        }

        int[] allNums = new int[numOfSquares]; //array to hold all the values

        //first storing values into array
        for (int i = 0; i < (allNums.length - 1); i++) {
            allNums[i] = digits.nextInt(9) + 1; //random number from 1 to 9
        }
        allNums[numOfSquares - 1] = 0; //the last stored number is 0

        if (RWC(allNums, numOfSquares)) {
            System.out.println("\nYou have escaped the cave, you win!");
            System.out.println("Play again? Enter Y or Yes to restart, or anything else to quit.");
            String tryAgain = kb.next();
            if (tryAgain.equalsIgnoreCase("Y") || tryAgain.equalsIgnoreCase("Yes")) {
                setupCave();
            } else {
                System.exit(0);
            }
        } else {
            System.out.println("\nGAME OVER!");
            System.out.println("Play again? Enter Y or Yes to restart, or anything else to quit.");
            String tryAgain = kb.next();
            if (tryAgain.equalsIgnoreCase("Y") || tryAgain.equalsIgnoreCase("Yes")) {
                setupCave();
            } else {
                System.exit(0);
            }
        }
    }//end of setupCave

    public static boolean RWC(int[] x, int nsq) {
        int markerPosition = 0; //current marker position
        int currentSquareVal = 1; //current square's value
        int leftGap; //amount of spaces on the marker's left
        int rightGap; //amount of spaces on the marker's right
        int positionOfZero = nsq - 1; //holds the position of 0
        boolean solved = false;

        Queue<Integer> gameQueue = new LinkedList<Integer>();

        do {

            for (int j = 0; j < nsq; j++) { //popularize the queue after they are dequeued
                gameQueue.add(x[j]);
            }

            for (int k = 0; k < nsq; k++) {
                if (k == markerPosition) {
                    currentSquareVal = gameQueue.peek();
                    System.out.print("(" + gameQueue.remove() + ")");
                } else {
                    System.out.print(" " + gameQueue.remove() + " ");
                }
            }

            leftGap = markerPosition;
            rightGap = nsq - markerPosition - 1;

            System.out.println();

            if ((markerPosition + currentSquareVal >= nsq) && (markerPosition - currentSquareVal < 0)) {
                System.out.println("There is not enough space to make a move. Unsolvable.");
                return false;
            } else if (markerPosition == positionOfZero) {
                solved = true;
            } else if ((leftGap > rightGap) && (markerPosition - currentSquareVal >= 0)) {
                markerPosition -= currentSquareVal;
            } else if ((rightGap > leftGap) && (markerPosition + currentSquareVal < nsq)) {
                markerPosition += currentSquareVal;
            } 
            

        } while (!solved); //win condition

        return true;

    }//end of RWC

}//end of class
