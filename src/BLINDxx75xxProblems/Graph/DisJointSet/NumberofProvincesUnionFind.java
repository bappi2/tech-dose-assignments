package BLINDxx75xxProblems.Graph.DisJointSet;

public class NumberofProvincesUnionFind {
    /*
    There are n cities. Some of them are connected, while some are not.
    If city a is connected directly with city b, and city b is connected
    directly with city c, then city a is connected indirectly with city c.

    A province is a group of directly or indirectly connected cities and
    no other cities outside of the group.

    You are given an n x n matrix isConnected where isConnected[i][j] = 1
    if the ith city and the jth city are directly connected, and
    isConnected[i][j] = 0 otherwise.

    Return the total number of provinces.
    Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    Output: 2
     */
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        int numConnectedComponent = isConnected.length;

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length -1; j++) {
                if (isConnected[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    numConnectedComponent--;
                    uf.unionbyRank(i, j);
                }
            }
        }
        return numConnectedComponent;
    }
}
