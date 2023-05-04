package BLINDxx75xxProblems.Graph.BFSProblems;

import BLINDxx75xxProblems.Graph.Node;
import BLINDxx75xxProblems.Graph.UndirectedGraphNode;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbors : curr.neighbors) {
                if (map.containsKey(neighbors)) {
                    map.get(curr).neighbors.add(map.get(neighbors));
                }
                else {
                    Node copy = new Node(neighbors.val);
                    map.put(neighbors, copy);
                    map.get(curr).neighbors.add(copy);
                    queue.offer(neighbors);
                }
            }
        }
        return newNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, newNode);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            List<UndirectedGraphNode> neighbors = curr.neighbors;

            for (UndirectedGraphNode neighbor : neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    map.get(curr).neighbors.add(newNeighbor);
                    queue.offer(neighbor);
                } else {
                    UndirectedGraphNode newNeighbor = map.get(neighbor);
                    map.get(curr).neighbors.add(newNeighbor);
                }
            }
        }

        return newNode;
    }


}
