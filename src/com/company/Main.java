package com.company;

import org.junit.Test;

/**
 * Finding the smallest positive integer (greater than 0) that does not occur in an array A
 *
 * Solution: (O(n) time complexity and O(1) space complexity)
 * The first missing positive integer will be always in the range from 1 to (array.length + 1) (L)
 * - If the array is empty, return 1
 * - Ignore negative values or too high index values (> array.length)
 * - Loop over the array with above conditions and arrange the array to get a sequence of positive integers 1,2,3,4,5...
 *   by swapping elements into the correct positions.
 * - Next loop, it would find the first value not in the correct position and then return i+1 that is the smallest
 *   positive integer
 * - If the end of loop is reached without returning value , then L+1 is the smallest positive integer
 *
 */

public class Main {

    public static void main(String[] args) {
        testGetFirstSmallestPositiveNumber();
    }

    private static int solution(int[] arr){
        int length = arr.length;
        if (length == 0) return 1;

        // iterate through the whole array mapping elements [1,n] to positions [0, n-1]
        for(int i = 0; i < length; i++ ){
            // while elements are not on their correct positions keep putting them there
            while(arr[i] > 0 && arr[i] <= length && arr[i] != i+1 && arr[i] != arr[arr[i] -1]){
                // Use swapping to keep constant space
                int tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
            }
        }

        // now, the first unmapped position is the smallest positive element
        for (int i = 0; i < length; i++){
            if(arr[i] != i+1) return i+1;
        }
        return length + 1;
    }

    @Test
    private static void testGetFirstSmallestPositiveNumber() {
        int[][] arrays = new int[][]{{2,-1,-8,-3,3,9,2,10,1000},
                {5, 4, 3, 2, 1},
                {0, 3, -100, -500000, 1900000,4,1}};

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(solution(arrays[i]));
        }
    }
}
