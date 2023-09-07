package BLINDxx75xxProblems.Graph.DisJointSet;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int numOfComponent = n;

        for (int[] edge: edges) {
            if (uf.unionbyRank(edge[0], edge[1])) {
                return false;
            }
            else {
                numOfComponent--;
            }
        }
        return numOfComponent == 1;
    }
}
