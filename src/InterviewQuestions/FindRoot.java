package InterviewQuestions;

import java.util.*;



public class FindRoot {
    static class Node {
        int id;
        List<Integer> children;

        public Node(int id, List<Integer> children) {
            this.id = id;
            this.children = children;
        }
    }
    public static int findRoot(List<Node> nodes) {
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> parents = new HashSet<>();

        for (Node node : nodes) {
            allNodes.add(node.id);
            parents.addAll(node.children);
        }

        for (Node node : nodes) {
            if (!parents.contains(node.id)) {
                return node.id; // This is the root
            }
        }

        return -1; // No root found
    }

    public static void main(String[] args) {
        List<Node> input1 = new ArrayList<>();
        input1.add(new Node(1, Arrays.asList(2)));
        input1.add(new Node(2, Arrays.asList(3)));
        input1.add(new Node(3, new ArrayList<>()));

        List<Node> input2 = new ArrayList<>();
        input2.add(new Node(15, Arrays.asList(1, 2)));
        input2.add(new Node(1, new ArrayList<>()));
        input2.add(new Node(9, Arrays.asList(4)));
        input2.add(new Node(10, Arrays.asList(15, 9)));

        int root1 = findRoot(input1);
        int root2 = findRoot(input2);

        System.out.println("Root of the first tree: " + root1); // Output: 1
        System.out.println("Root of the second tree: " + root2); // Output: 10
    }
}
