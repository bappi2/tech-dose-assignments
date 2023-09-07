package BLINDxx75xxProblems.Graph.DisJointSet;

import java.util.Arrays;

class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            if (uf.unionbyRank(u, v)) {
                return edges[i];
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        FindRedundantConnection uf = new FindRedundantConnection();
        System.out.println(Arrays.stream(uf.findRedundantConnection(edges)).toArray());
    }

}