package BLINDxx75xxProblems.Graph.DFSProblems;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }

        // step 1: build the ajdList
        Map<String, List<String>> adjList = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            if (adjList.containsKey(from)) {
                adjList.get(from).add(to);
            } else {
                List<String> neighbors = new ArrayList<>();
                neighbors.add(to);
                adjList.put(from, neighbors);
            }
        }

        // step 2: sort the adjlist according to lex order
        for (String from : adjList.keySet()) {
            List<String> neighbors = adjList.get(from);
            Collections.sort(neighbors);
        }

        // step 3: start the dfs
        findItineraryHelper("JFK", adjList, result);

        return result;
    }

    private void findItineraryHelper(String curr, Map<String, List<String>> adjList, List<String> result) {

        List<String> neighbors = adjList.get(curr);

        if (neighbors != null) {
            while (neighbors.size() > 0) {
                String neighbor = neighbors.get(0);
                neighbors.remove(0);
                findItineraryHelper(neighbor, adjList, result);
            }
        }

        result.add(0, curr);
    }
}
