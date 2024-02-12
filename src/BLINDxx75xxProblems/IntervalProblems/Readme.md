
## Question: In an interval problem, how to know whether to sort by start time or by end time?
The decision to sort by start time or end time in an interval problem depends on the specific requirements of the problem. Here are some general guidelines:

* Sort by Start Time: If you're merging intervals or looking for overlapping intervals, you'll typically sort by start time. This allows you to easily compare the end time of the current interval with the start time of the next interval to see if they overlap.

* Sort by End Time: If you're trying to find the maximum number of non-overlapping intervals (like in the activity selection problem), you'll typically sort by end time. This allows you to pick the interval that ends the earliest, ensuring you have the maximum amount of time left for the remaining intervals.

Remember, these are just general guidelines. The specific problem you're trying to solve could require a different approach. Always make sure to understand the problem requirements fully before deciding on your strategy.

The merge intervals problem is a common coding problem that involves dealing with intervals of numbers and merging overlapping ones. The problem can be solved using various algorithms, and it's a great exercise to improve your skills in sorting, array manipulation, and interval handling.
Here's a general description of the problem:

Given a collection of intervals, merge any overlapping intervals.

For example:

Input: [[1,3], [2,6], [8,10], [15,18]]
Output: [[1,6], [8,10], [15,18]]

* Merge Intervals (Medium): https://leetcode.com/problems/merge-intervals/
* Insert Interval (Medium): https://leetcode.com/problems/insert-interval/
* Meeting Rooms II (Medium): https://leetcode.com/problems/meeting-rooms-ii/
* Non-overlapping Intervals (Medium): https://leetcode.com/problems/non-overlapping-intervals/
* Employee Free Time (Hard): https://leetcode.com/problems/employee-free-time/

## Why sort by Start Time in Merge Intervals problem whereas we sort by End Time in Non Overalapping Intervals problem?
In the Merge Intervals problem, we sort by start times to ensure that we process the intervals in chronological order. This makes it easier to determine if an interval overlaps with the previous one and if it should be merged.
When intervals are sorted by start times, any overlap between intervals can only occur between adjacent intervals in the sorted list. As we iterate through the sorted intervals, we can easily identify overlapping intervals and merge them.
Sorting by start times also ensures that the merged intervals are produced in a non-overlapping, chronological order, which is typically the desired output format for the problem.  
<br>
Sorting by end times for the Merge Intervals problem is not a good idea because it doesn't guarantee that overlapping intervals will be adjacent in the sorted list. This makes it harder to identify and merge overlapping intervals correctly as you iterate through the list.
<br>
Consider the following example:  
Intervals: [[1, 5], [2, 6], [7, 8], [3, 4]]
<br>
If you sort by end times, you'll get:
Sorted by end times: [[1, 5], [3, 4], [2, 6], [7, 8]]  
<br>
As you can see, the intervals [1, 5] and [2, 6] should be merged, but they are not adjacent in the sorted list. Therefore, simply iterating through the list and merging adjacent intervals would produce an incorrect result.
<br>
On the other hand, if you sort by start times, you'll get:
Sorted by start times: [[1, 5], [2, 6], [3, 4], [7, 8]]
<br>
Now, the overlapping intervals [1, 5] and [2, 6] are adjacent, and you can easily identify and merge them as you iterate through the list. The correct merged intervals are [[1, 6], [7, 8]].
<br>
<b>In summary, sorting by end times for the Merge Intervals problem is not a suitable approach because it doesn't guarantee that overlapping intervals will be adjacent in the sorted list, which makes it difficult to identify and merge overlapping intervals correctly. Sorting by start times is the preferred approach for this problem.
</b>
<br>

For the NonOverlappingIntevals problem, Sorting by end times is crucial in this problem because it helps you make a greedy choice at each step, which ultimately leads to an optimal solution.
When you sort the intervals by their end times, you're prioritizing intervals that finish earlier, which leaves more room for accommodating other intervals without overlaps.
The key insight is that selecting an interval with the earliest end time maximizes the chance of fitting the next interval without overlapping.

By iterating through the sorted intervals and counting non-overlapping intervals, you ensure that you're always choosing intervals that don't overlap with the current non-overlapping interval set. By sorting by end times, you make the greedy choice that leads to an optimal solution for the problem.

To illustrate this with an example, consider the input intervals [[1,4],[2,3],[3,5],[6,7]].
When sorted by end times, the intervals become [[2,3],[1,4],[3,5],[6,7]]. By choosing the intervals with the earliest end times, you can keep [[2,3],[6,7]], which don't overlap. The minimum number of intervals to remove is 2 (i.e., [1,4] and [3,5]).

