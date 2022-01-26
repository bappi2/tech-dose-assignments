package SortingAlgorithm;

public class SelectionSort {
/*
The selection sort algorithm sorts an array by repeatedly finding the minimum
element (considering ascending order) from unsorted part and putting it at the beginning.
The algorithm maintains two subarrays in a given array.
1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.
 */

    public static void selectionSort(int [] nums) {
        int len = nums.length;

        for (int i=0; i< len -1; i++) {
            int min_index = i;
             for (int j=i+1; j < len; j++) {
                if (nums[j] < nums[min_index]) {
                    min_index = j;
                }
            }
            int temp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = temp;
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int [] nums = { 10, 2, 5, 4, 1, 8, 7};
        printArray( nums);

        selectionSort(nums);

        printArray(nums);
    }

}
