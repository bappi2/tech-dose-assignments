package SortingAlgorithm;

public class BubbleSort {

    public static void bubbleSort(int [] nums) {
        int len = nums.length;
        for (int i=0; i < len; i++) {
            for (int j=1; j < len - i; j++) {
                if (nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
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

        bubbleSort(nums);

        printArray(nums);
    }
}