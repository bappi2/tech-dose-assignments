package BLINDxx75xxProblems.Graph.DisJointSet;

public class NumberConnectedComponentsUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int numOfComponent = n;
        for (int[] edge: edges){
            if (!uf.unionbyRank(edge[0], edge[1])) {
                numOfComponent--;
            }
        }
        return numOfComponent;
    }
}
