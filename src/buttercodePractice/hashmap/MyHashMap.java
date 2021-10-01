package buttercodePractice.hashmap;

public class MyHashMap  {
    class Node{
        final int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    final int SIZE = 10001;
    Node[] array;
    public MyHashMap() {
        array = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = array[index];
        Node node = head;
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
    }


    public int get(int key) {
        int index = hash(key);
        Node node = array[index];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node node = array[index];
        while (node != null) {
            if (node.key == key) {
                node.value = -1;
                return;
            }
            node = node.next;
        }

    }

    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */