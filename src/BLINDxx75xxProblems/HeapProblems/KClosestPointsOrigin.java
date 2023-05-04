package BLINDxx75xxProblems.HeapProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    /*
https://leetcode.com/problems/k-closest-points-to-origin/description/
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).\
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

NOTES:
Since we need k "closest" points (minimum distances), we start with a Max Heap PQ.
Priority of the PQ is the actual distance of the point from the origin.
Using Comparable class makes it possible for us to define the ordering in the Point class itself.
Notice, how compareTo is coded reverse way.
 */
    static class Point implements Comparable<Point> {
        int x;
        int y;
        Double distanceFromOrigin;

        public Point(int _x, int _y){
            x = _x;
            y = _y;
            distanceFromOrigin = computeDistance();
        }
        private Double computeDistance(){
            return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
        }

        // Implement Max Heap. Hence reverse order
        @Override
        public int compareTo(Point o) {
            return o.distanceFromOrigin.compareTo(this.distanceFromOrigin);
        }
    }
        public static int[][] kClosest(int[][] points, int k) {
            if (points == null || k == 0 || points.length < k){
                return new int[0][];
            }
            PriorityQueue<Point> pq = new PriorityQueue<>();
            for (int[] point : points){
                pq.add(new Point(point[0], point[1]));
                if (pq.size() > k){
                    pq.poll();
                }
            }
            System.out.println(pq.size());
            int[][] results = new int[pq.size()][2];
            for (int[] result : results){
                Point p = pq.poll();
                result[0] = p.x;
                result[1] = p.y;
            }
            return results;
        }

        public static void main(String[] args) {
            int[][] points = new int[][]{{1,3},{-2,2}};
            KClosestPointsOrigin sol = new KClosestPointsOrigin();
            System.out.println(Arrays.deepToString(kClosest(points, 1)));
        }
}
