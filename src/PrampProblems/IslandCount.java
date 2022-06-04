package PrampProblems;

public class IslandCount {

    /*
    Island Count
Given a 2D array binaryMatrix of 0s and 1s, implement a function
getNumberOfIslands that returns the number of islands of 1s in binaryMatrix.

An island is defined as a group of adjacent values that are all 1s.
A cell in binaryMatrix is considered adjacent to another cell if they
are next to each either on the same row or column. Note that two values
of 1 are not part of the same island if they’re sharing only a mutual
“corner” (i.e. they are diagonally neighbors).

Explain and code the most efficient solution possible and analyze its
time and space complexities.

Example:

input:  binaryMatrix = [ [0,    1,    0,    1,    0],
                         [0,    0,    1,    1,    1],
                         [1,    0,    0,    1,    0],
                         [0,    1,    1,    0,    0],
                         [1,    0,    1,    0,    1] ]

output: 6 // since this is the number of islands in binaryMatrix.
          // See all 6 islands color-coded below.
     */

    static void pushIfValid(Queue q,int row,int col,int x,int y) {
        if (x>=0 && x<row && y>=0 && y<col) {
            q.add(new int[] {x,y});
        }
    }
    static void markIsland(int[][] binaryMatrix,int row,int col,int r,int c) {
        Queue<int []> q = new LinkedList<int []>();
        q.add(new int[] {r,c});
        while (q.peek()!=null) {
            int[] item = q.poll();
            int x = item[0], y = item[1];
            if (binaryMatrix[x][y]==1) {
                binaryMatrix[x][y]=2;
                pushIfValid(q,row,col,x-1,y);
                pushIfValid(q,row,col,x+1,y);
                pushIfValid(q,row,col,x,y-1);
                pushIfValid(q,row,col,x,y+1);
            }
        }
    }

    static int getNumberOfIslands(int[][] binaryMatrix) {
        int islands = 0;
        int row = binaryMatrix.length, col = binaryMatrix[0].length;
        for (int r=0;r<row;r++) {
            for (int c=0;c<col;c++) {
                if (binaryMatrix[r][c]==1) {
                    islands++;
                    markIsland(binaryMatrix,row,col,r,c);
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        int[][] binaryMatrix = {{0,    1,    0,    1,    0},
                {0,    0,    1,    1,    1},
                {1,    0,    0,    1,    0},
                {0,    1,    1,    0,    0},
                {1,    0,    1,    0,    1}};
        // Expected output: 6
        // since this is the number of islands in binaryMatrix
        System.out.println(getNumberOfIslands(binaryMatrix));
    }

}
