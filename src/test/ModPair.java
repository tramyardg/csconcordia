/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ModPair {

    public static void main(String[] args) {
        int[] A = {123, 73, 39, 12, 14, 9, 113, 93, 203, 22, 25, 10};
        System.out.println(modPairString(A, 3));
    }

    /**
     * All pairs of elements of the array that modulo up to a value of 3 are:
     * Indices 0 & 3 with values 123 & 12 (e.g., 12 3 % 12 returns 3) Indices 1
     * & 5 with values 73 & 14 Indices 2 & 4 with values 39 & 9 Indices 6 & 11
     * with values 113 & 22 etc.
     */
    /**
     *
     * @param A
     * @param x
     * @return
     */
    public static String modPairString(int[] A, int x) {
        String str = "All pairs of elements of the array that modulo up to a value of " + x + " are: \n";
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length - 1; j++) {
                if (A[i] % A[j + 1] == x) {
                    str += "Indices " + i + " & " + (j+1) + " with values " + A[i] + " & " + A[j + 1] + " \n";
                }
            }

        }

        return str;
    }
}
