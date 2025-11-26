package BLINDxx75xxProblems.Graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors,-1);
        for(int i=0; i<n; i++){
            if(colors[i] == -1){
                if(!bfs(i,graph,colors)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int min, int[][]graph,int[] colors){
        Queue<Integer> q = new LinkedList<>();
        colors[min] = 0;
        q.add(min);
        while(!q.isEmpty()){
            int node = q.poll();

            for(int adjNode : graph[node]){
                if(colors[adjNode] == -1){
                    colors[adjNode] = colors[node] == 1 ? 0 : 1;
                    q.add(adjNode);
                }
                else if(colors[adjNode] == colors[node]) return false;
            }
        }
        return true;
    }
}