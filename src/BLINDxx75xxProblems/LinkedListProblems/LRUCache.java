package BLINDxx75xxProblems.LinkedListProblems;

public class LRUCache {
    // https://leetcode.com/problems/lru-cache/description/

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    private void setHead(Node n) {
        n.nxt = head;
        n.pre = null;
        if (head !=null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }

    private void remove(Node n) {
        if (n.pre != null) {
            n.pre.nxt = n.nxt;
        }
        else {
            head = n.nxt;
        }
        if (n.nxt != null) {
            n.nxt.pre = n.pre;
        }
        else {
            end = n.pre;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            setHead(n);
        }
        else  {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            }
            else {

                setHead(created);
            }
            map.put(key, created);

        }

    }
    class Node {
        int key;
        int value;
        Node pre;
        Node nxt;

        public  Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


