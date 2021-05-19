package SortingAlgorithm;

public class InsertionSort {
    public static void insertionSort(int [] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
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

        insertionSort(nums);

        printArray(nums);
    }
}
