package BLINDxx75xxProblems.SortingAlgorithm;

public class DutchNationalFlagProblem {
    // Example 1:
    //
    //Input: nums = [2,0,2,1,1,0]
    //Output: [0,0,1,1,2,2]
    //Example 2:
    //
    //Input: nums = [2,0,1]
    //Output: [0,1,2]
    static void sort012(int a[], int arr_size)
    {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }
}
