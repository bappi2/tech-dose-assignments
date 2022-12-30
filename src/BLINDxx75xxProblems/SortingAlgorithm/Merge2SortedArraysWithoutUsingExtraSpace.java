package BLINDxx75xxProblems.SortingAlgorithm;

import java.util.Arrays;

public class Merge2SortedArraysWithoutUsingExtraSpace {
    /*
    Efficient Approach: To solve the problem follow the below idea:

The idea is to begin from the last element of ar2[] and search for it in ar1[]. If there is a greater element in ar1[], then we move the last element of ar1[] to ar2[]. To keep ar1[] and ar2[] sorted, we need to place the last element of ar2[] at the correct place in ar1[]. We can use the Insertion Sort for this

Follow the below steps to solve the problem:

Iterate through every element of ar2[] starting from the last element
Do the following for every element ar2[i]
Store last element of ar1[]: last = ar1[m-1]
Loop from the second last element of ar1[] while element ar1[j] is greater than ar2[i].
ar1[j+1] = ar1[j] Move element one position ahead, then j–
If last element of ar1[] is greater than ar2[i], then ar1[j+1] = ar2[i] and ar2[i] = last
     */

    static int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
    static int arr2[] = new int[] { 2, 3, 8, 13 };

    static void merge(int m, int n)
    {
        // Iterate through all elements of ar2[] starting
        // from the last element
        for (int i = n - 1; i >= 0; i--) {
            /* Find the smallest element greater than
               ar2[i]. Move all elements one position ahead
               till the smallest greater element is not
               found */
            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i];
                 j--)
                arr1[j + 1] = arr1[j];

            // If there was a greater element
            if (last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        merge(arr1.length, arr2.length);
        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}
