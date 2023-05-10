package BLINDxx75xxProblems.Graph.BFSProblems;

import BLINDxx75xxProblems.Graph.Node;
import BLINDxx75xxProblems.Graph.UndirectedGraphNode;

import java.util.*;
/*
Algorithm

We will use a hash map to store the reference of the copy of all the nodes
that have already been visited and copied. The key for the hash map would
be the node of the original graph and corresponding value would be the
corresponding cloned node of the cloned graph. The visited is used to prevent
cycles and get the cloned copy of a node.

Add the first node to the queue. Clone the first node and add it to visited hash map.

Do the BFS traversal.

Pop a node from the front of the queue.
Visit all the neighbors of this node.
If any of the neighbors was already visited then it must be present in the
visited dictionary. Get the clone of this neighbor from visited in that case.
Otherwise, create a clone and store in the visited.
Add the clones of the neighbors to the corresponding list of the clone node.
 */
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
